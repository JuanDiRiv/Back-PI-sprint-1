package com.pi.proyectoIntegrador.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (nullable = false)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String url;

    public Category() {
    }

    public Category(Long id, String title, String description, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public Category(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }
}