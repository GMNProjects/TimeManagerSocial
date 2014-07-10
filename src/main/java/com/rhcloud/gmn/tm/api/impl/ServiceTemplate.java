package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.ServiceOperations;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;

/**
 * Created by niaz on 07.07.2014.
 */
public class ServiceTemplate extends OperationTemplate implements ServiceOperations {

    private String access_token;
    private RestTemplate restTemplate;

    public ServiceTemplate(boolean isAuthorized, String access_token, RestTemplate restTemplate) {
        super(isAuthorized, access_token);
        this.restTemplate = restTemplate;
        this.access_token = access_token;
    }

    @Override
    public Service addService(Service service) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("client", service.getClient().getName());
        params.set("work", service.getWork().getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        params.set("date", sdf.format(service.getDate()));
        params.set("time", String.valueOf(service.getTime()));
        URI uri = buildOperation(Service.SERVICE_ADD, params);
        ResponseEntity<Service> clientResponseEntity = restTemplate.getForEntity(uri, Service.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Service getService(long id) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(id));
        URI uri = buildOperation(Service.SERVICE_GET, params);
        ResponseEntity<Service> clientResponseEntity = restTemplate.getForEntity(uri, Service.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public MessageCode deleteService(Service service) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(service.getS_id()));
        URI uri = buildOperation(Service.SERVICE_DELETE, params);
        ResponseEntity<MessageCode> clientResponseEntity = restTemplate.getForEntity(uri, MessageCode.class);
        return clientResponseEntity.getBody();
    }

}
