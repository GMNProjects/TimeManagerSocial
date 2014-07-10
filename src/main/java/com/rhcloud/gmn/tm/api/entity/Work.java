package com.rhcloud.gmn.tm.api.entity;

/**
 * Created by niaz on 27.04.14.
 */


import java.io.Serializable;

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
        return "Work {" + w_id + "," + name + "}";
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
