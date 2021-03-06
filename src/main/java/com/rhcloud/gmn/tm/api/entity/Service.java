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
package com.rhcloud.gmn.tm.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GMNProjects
 *
 * Service entity. Contain information about service.
 */
public class Service {

    public static final char BEFORE = 0x003C;
    public static final char AFTER = 0x003E;

    public static final String SERVICE_ADD = "service.add";
    public static final String SERVICE_GET = "service.get";
    public static final String SERVICE_DELETE = "service.delete";
    public static final String SERVICE_ALL = "service.all";

    private Long s_id;

    private Client client;

    private Work work;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private long time;

    public Service() {
    }

    /**
     * @param time
     */
    public Service(Client client, Work work, long time) {
        Date d = new Date();
        this.date = d;
        this.time = time;
        this.client = client;
        this.work = work;
    }

    public Service(Work work, Client client, Date date, long time) {
        this.work = work;
        this.client = client;
        this.date = date;
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Date getDate() {
        return date;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setDate(Date date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long id) {
        this.s_id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Service service = (Service) obj;
        return (service.getClient().equals(this.client) && service.getWork().equals(this.work) && obj != null);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Service[id:"+s_id+",client:"+getClient().toString()+",work:"+getWork().toString()
                +",date:"+sdf.format(date)+",time:"+time+"]";
    }
}
