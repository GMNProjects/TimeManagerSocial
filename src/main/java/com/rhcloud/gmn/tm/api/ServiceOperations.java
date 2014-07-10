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
package com.rhcloud.gmn.tm.api;

import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Service;
import org.springframework.web.client.RestClientException;

/**
 * @author GMNProjects
 */
public interface ServiceOperations {
    /**
     * Add {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param  service добавляемый объект
     * @return {@link com.rhcloud.gmn.tm.api.entity.Service}
     * @throws RestClientException
     */
    public Service addService(Service service) throws RestClientException;

    /**
     * Get {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param id {@link Long}
     * @return {@link com.rhcloud.gmn.tm.api.entity.Service}
     * @throws RestClientException
     */
    public Service getService(long id) throws RestClientException;

    /**
     * Delete {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param service
     * @return {@link com.rhcloud.gmn.tm.api.entity.MessageCode}
     * @throws RestClientException
     */
    public MessageCode deleteService(Service service) throws RestClientException;

}
