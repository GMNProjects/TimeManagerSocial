package com.rhcloud.gmn.tm.api;

import com.rhcloud.gmn.tm.api.entity.MessageCode;
import com.rhcloud.gmn.tm.api.entity.Work;
import org.springframework.web.client.RestClientException;

/**
 * Created by niaz on 06.07.2014.
 */
public interface WorkOperations {
    /**
     * Удалить {@link com.rhcloud.gmn.tm.api.entity.Work} по id
     * @param work
     * @return
     * @throws RestClientException
     */
    public MessageCode deleteWork(Work work) throws RestClientException;

    /**
     * Получить {@link com.rhcloud.gmn.tm.api.entity.Work} по id {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param id
     * @return
     * @throws RestClientException
     */
    public Work getWork(long id) throws RestClientException;

    /**
     * Добавить {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param work
     * @return
     * @throws RestClientException
     */
    public Work addWork(Work work) throws RestClientException;

    /**
     * Обновить {@link com.rhcloud.gmn.tm.api.entity.Work}
     * @param work
     * @return
     * @throws RestClientException
     */
    public Work updateWork(Work work) throws RestClientException;

}
