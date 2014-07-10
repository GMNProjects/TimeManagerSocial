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

import com.rhcloud.gmn.tm.api.entity.Client;
import com.rhcloud.gmn.tm.api.entity.MessageCode;
import org.springframework.web.client.RestClientException;

/**
 * @author GMNProjects
 * Интерфейс  Client API
 *
 */
public interface ClientOperations {
    /**
     * Получуть клиента по id
     * @param id
     * @return Client
     * @throws RestClientException
     */
    public Client getClient(long id) throws RestClientException;

    /**
     * Добавить клиента
     * @param client
     * @return
     * @throws RestClientException
     */
    public Client addClient(Client client) throws RestClientException;

    /**
     * Удалить клиента
     * @param client Замечание: объект Client должен иметь id
     * @return
     * @throws RestClientException
     */
    public MessageCode deleteClient(Client client) throws RestClientException;

    /**
     * Обновить клента
     * @param client Замечание: объект Client должен иметь id
     * @return
     * @throws RestClientException
     */
    public Client updateClient(Client client) throws RestClientException;
}
