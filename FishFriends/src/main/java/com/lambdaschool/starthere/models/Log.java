package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "log")
public class Log extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long logid;

    private User user;
    private String timespent;
    private String baittype;

    @OneToMany(mappedBy = "log",
    cascade = CascadeType.ALL)
    @JsonIgnoreProperties("log")
    private List<Fish> fishcaught = new ArrayList<>();
}
