package com.pi_grupo6.pi.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Categories")
public class Categories {
    @Id
    @SequenceGenerator(name = "categories_sequence", sequenceName = "categories_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categories_sequence")
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String url;


}
