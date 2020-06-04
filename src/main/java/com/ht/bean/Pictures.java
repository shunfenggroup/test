package com.ht.bean;

import java.util.Date;

public class Pictures {

    private Integer id;
    private String pname;
    private String psrc;
    private Date ptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsrc() {
        return psrc;
    }

    public void setPsrc(String psrc) {
        this.psrc = psrc;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", psrc='" + psrc + '\'' +
                ", ptime=" + ptime +
                '}';
    }
}
