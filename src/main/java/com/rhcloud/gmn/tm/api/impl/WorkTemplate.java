package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.WorkOperations;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by niaz on 07.07.2014.
 */
public class WorkTemplate extends OperationTemplate implements WorkOperations {
    private String access_token;
    private RestTemplate restTemplate;

    public WorkTemplate(boolean isAuthorized, String access_token, RestTemplate restTemplate) {
        super(isAuthorized, access_token);
        this.access_token = access_token;
        this.restTemplate = restTemplate;
    }

    @Override
    public MessageCode deleteWork(Work work) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(work.getW_id()));
        URI uri = buildOperation(Work.WORK_DELETE, params);
        ResponseEntity<MessageCode> clientResponseEntity = restTemplate.getForEntity(uri, MessageCode.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Work getWork(long id) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(id));
        URI uri = buildOperation(Work.WORK_UPDATE, params);
        ResponseEntity<Work> clientResponseEntity = restTemplate.getForEntity(uri, Work.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Work addWork(Work work) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("work", work.getName());
        URI uri = buildOperation(Work.WORK_ADD, params);
        ResponseEntity<Work> clientResponseEntity = restTemplate.getForEntity(uri, Work.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Work updateWork(Work work) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(work.getW_id()));
        params.set("work", work.getName());
        URI uri = buildOperation(Work.WORK_UPDATE, params);
        ResponseEntity<Work> clientResponseEntity = restTemplate.getForEntity(uri, Work.class);
        return clientResponseEntity.getBody();
    }
}
