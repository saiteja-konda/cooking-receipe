package com.teja.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visit_log")
public class VisitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ip;
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT-8")
    private Date time;

    public VisitLog() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VisitLog{" +
            "id=" + id +
            ", ip='" + ip + '\'' +
            ", location='" + location + '\'' +
            ", time=" + time +
            '}';
    }
}
