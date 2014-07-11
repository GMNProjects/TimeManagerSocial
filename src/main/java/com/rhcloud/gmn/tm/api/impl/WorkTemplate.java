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

import com.rhcloud.gmn.tm.api.WorkOperations;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Work;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
 *         {@link WorkOperations} implementation
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
        URI uri = buildOperation(Work.WORK_GET, params);
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

    @Override
    public List<Work> getAll() throws RestClientException {
        checkAuthorization();
        URI uri = buildOperation(Work.WORK_ALL, null);
        ResponseEntity<Work[]> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Work[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
