package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.ClientOperations;
import com.rhcloud.gmn.tm.api.entity.Client;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by niaz on 04.07.2014.
 */
public class ClientTemplate extends OperationTemplate implements ClientOperations {

    private String access_token;
    private RestTemplate restTemplate;

    public ClientTemplate(boolean isAuthorized, String access_token, RestTemplate restTemplate) {
        super(isAuthorized, access_token);
        this.access_token = access_token;
        this.restTemplate = restTemplate;
    }

    @Override
    public Client getClient(long id) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(id));
        URI uri = buildOperation(Client.CLIENT_GET, params);
        ResponseEntity<Client> clientResponseEntity = restTemplate.getForEntity(uri, Client.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Client addClient(Client client) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("client", client.getName());
        URI uri = buildOperation(Client.CLIENT_ADD, params);
        ResponseEntity<Client> clientResponseEntity = restTemplate.getForEntity(uri, Client.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public MessageCode deleteClient(Client client) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(client.getC_id()));
        URI uri = buildOperation(Client.CLIENT_DELETE, params);
        ResponseEntity<MessageCode> clientResponseEntity = restTemplate.getForEntity(uri, MessageCode.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public Client updateClient(Client client) throws RestClientException {
        checkAuthorization();
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(client.getC_id()));
        params.set("client", client.getName());
        URI uri = buildOperation(Client.CLIENT_UPDATE, params);
        ResponseEntity<Client> clientResponseEntity = restTemplate.getForEntity(uri, Client.class);
        return clientResponseEntity.getBody();
    }
}
