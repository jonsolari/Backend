package com.lambdaschool.starthere.models;

import javax.persistence.*;

public class Fish
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fishid;

    @Column
    private String fishquantity;
    private String fishtype;

    @ManyToOne
    @JoinColumn(name = "logid",
                nullable = false)
    private Log log;
}
