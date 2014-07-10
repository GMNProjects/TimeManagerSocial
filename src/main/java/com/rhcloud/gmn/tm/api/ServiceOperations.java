package com.rhcloud.gmn.tm.api;

import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Service;
import org.springframework.web.client.RestClientException;

/**
 * @author GMNProjects
 */
public interface ServiceOperations {
    /**
     * Добавить {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param  service добавляемый объект
     * @return {@link com.rhcloud.gmn.tm.api.entity.Service}
     * @throws RestClientException
     */
    public Service addService(Service service) throws RestClientException;

    /**
     * Получить {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param id {@link Long}
     * @return {@link com.rhcloud.gmn.tm.api.entity.Service}
     * @throws RestClientException
     */
    public Service getService(long id) throws RestClientException;

    /**
     * Удалить {@link com.rhcloud.gmn.tm.api.entity.Service}
     *
     * @param service
     * @return {@link com.rhcloud.gmn.tm.api.entity.MessageCode}
     * @throws RestClientException
     */
    public MessageCode deleteService(Service service) throws RestClientException;

}
