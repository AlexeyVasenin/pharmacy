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
    private String fcId;
    private String fcCategoryId;
    private String fcCountryId;

    @ManyToOne
    @JoinColumn(name = "fcCountryId", referencedColumnName = "countryid")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "fcCategoryId", referencedColumnName = "categoryid")
    private Category category;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;
}
