package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;
    private String title;





}
