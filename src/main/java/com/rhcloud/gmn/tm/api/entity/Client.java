package com.rhcloud.gmn.tm.api.entity;

/**
 * Created by niaz on 27.04.14.
 *
 */

import java.io.Serializable;

public class Client implements Serializable {

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
