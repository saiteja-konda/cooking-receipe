package com.teja.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_operation_log")
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ip;
    private String args;
    private String method;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT-8")
    private Date time;
    private String description;
    private Long timeSpent;
    private String location;

    public OperationLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
            "id=" + id +
            ", ip='" + ip + '\'' +
            ", args='" + args + '\'' +
            ", method='" + method + '\'' +
            ", time=" + time +
            ", description='" + description + '\'' +
            ", timeSpent=" + timeSpent +
            ", location='" + location + '\'' +
            '}';
    }
}
