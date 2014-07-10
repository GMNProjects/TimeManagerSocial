package com.rhcloud.gmn.tm.api.entity;

/**
 * Created by niaz on 04.06.14.
 */
public class MessageCode {

    private int code;

    public MessageCode() {
    }

    public MessageCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        switch (code) {
            case 1:
                return "Success!";
        }
        return "Error!";
    }
}
