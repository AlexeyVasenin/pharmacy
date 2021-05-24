package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Drug {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToMany
    private List<Ingredient> ingredients;
}
