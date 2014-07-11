/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rhcloud.gmn.tm.api.impl;

import com.rhcloud.gmn.tm.api.ClientOperations;
import com.rhcloud.gmn.tm.api.entity.Client;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * @author GMNProjects
 *         <p/>
 *         {@link ClientOperations} implementation
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
        Assert.notNull(id, "ID must be set...");
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
        Assert.notNull(client.getName(), "Client name must be set...");
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("client", client.getName());
        URI uri = buildOperation(Client.CLIENT_ADD, params);
        ResponseEntity<Client> clientResponseEntity = restTemplate.getForEntity(uri, Client.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public MessageCode deleteClient(Client client) throws RestClientException {
        Assert.notNull(client.getC_id(), "ID must be set...");
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
        Assert.notNull(client.getC_id(), "ID must be set...");
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("id", String.valueOf(client.getC_id()));
        params.set("client", client.getName());
        URI uri = buildOperation(Client.CLIENT_UPDATE, params);
        ResponseEntity<Client> clientResponseEntity = restTemplate.getForEntity(uri, Client.class);
        return clientResponseEntity.getBody();
    }

    @Override
    public List<Client> getAll() throws RestClientException {
        checkAuthorization();
        URI uri = buildOperation(Client.CLIENT_ALL, null);
        ResponseEntity<Client[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Client[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
