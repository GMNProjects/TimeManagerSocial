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

import java.io.Serializable;

/**
 * @author GMNProjects
 */
public class Work implements Serializable {

    /**
     * Delete Work method
     */
    public static final String WORK_DELETE = "work.delete";

    /**
     * Add Work method
     */
    public static final String WORK_ADD = "work.add";

    /**
     * Update Work method
     */
    public static final String WORK_UPDATE = "work.update";

    /**
     * Get Work method
     */
    public static final String WORK_GET = "work.get";

    /**
     * Get All method
     */
    public static final String WORK_ALL = "work.all";

    private Long w_id;
    private String name;

    public Work() {
    }

    public Work(Long w_id) {
        this.w_id = w_id;
    }

    public Work(Long id, String name) {
        this.w_id = id;
        this.name = name;
    }

    public Work(String name) {
        this.name = name;
    }


    public Long getW_id() {
        return w_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


//    @Override
//    public boolean equals(Object obj) {
//        Logger.getLogger(Work.class).info("Work equals");
//        Work work = (Work) obj;
//        return (work.getName().equals(this.getName()));
//    }


    public void setW_id(Long w_id) {
        this.w_id = w_id;
    }
}
