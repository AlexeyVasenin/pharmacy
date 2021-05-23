package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Country {
    @Id
    @GeneratedValue
    private long id;
    private String name;


}
