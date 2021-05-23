package ru.vasenin.pharmacy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @JoinColumn()
    private Country country ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;


}
