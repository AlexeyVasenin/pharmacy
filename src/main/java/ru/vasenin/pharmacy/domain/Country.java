package ru.vasenin.pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Country {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Drug> drugs;
}
