package com.ringcentral.test.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Segment {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;
}
