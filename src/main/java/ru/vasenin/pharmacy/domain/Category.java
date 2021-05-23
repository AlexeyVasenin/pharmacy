package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue
    private long id;
    private String title;




}
