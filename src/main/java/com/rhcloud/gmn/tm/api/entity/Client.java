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

/**
 * @author GMNProjects
 *
 * Client entity. Contain information about client.
 *
 */
public class Client {

    public static final String CLIENT_ADD = "client.add";
    public static final String CLIENT_GET = "client.get";
    public static final String CLIENT_DELETE = "client.delete";
    public static final String CLIENT_UPDATE = "client.update";

    private Long c_id;

    private String name;

    public Client() {
    }

    public Client(Long a_id) {
        c_id = a_id;
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(Long id, String name) {
        this.c_id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Client {" + c_id + "," + name + "}";
    }

}
