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
