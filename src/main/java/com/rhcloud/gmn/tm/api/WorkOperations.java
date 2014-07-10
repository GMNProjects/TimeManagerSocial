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
import com.rhcloud.gmn.tm.api.entity.Work;
import org.springframework.web.client.RestClientException;

/**
 * @author GMNProjects
 */
public interface WorkOperations {
    /**
     * Delete {@link com.rhcloud.gmn.tm.api.entity.Work} по id
     * @param work
     * @return
     * @throws RestClientException
     */
    public MessageCode deleteWork(Work work) throws RestClientException;

    /**
     * Get {@link com.rhcloud.gmn.tm.api.entity.Work} по id {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param id
     * @return
     * @throws RestClientException
     */
    public Work getWork(long id) throws RestClientException;

    /**
     * Add {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param work
     * @return
     * @throws RestClientException
     */
    public Work addWork(Work work) throws RestClientException;

    /**
     * Update {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param work
     * @return
     * @throws RestClientException
     */
    public Work updateWork(Work work) throws RestClientException;

}
