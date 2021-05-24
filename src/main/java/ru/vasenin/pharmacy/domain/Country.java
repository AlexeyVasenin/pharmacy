package ru.vasenin.pharmacy.domain;

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

    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST, fetch =
            FetchType.EAGER)
    private List<Drug> drugs;

}
