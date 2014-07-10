package com.rhcloud.gmn.tm.api;

import org.springframework.social.ApiBinding;

/**
 * Created by niaz on 06.07.2014.
 */
public interface TimeManager extends ApiBinding {
    /**
     * API для Client
     * @return
     */
    public ClientOperations clientOperations() ;

    /**
     * API для Work
     * @return
     */
    public WorkOperations workOperations() ;

    /**
     * API для User
     * @return
     */
    public UserOperations userOperations() ;

    /**
     * API для Service
     * @return
     */
    public ServiceOperations serviceOperations() ;
}
