package com.univ.parcJardin_Spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParcJardin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(length = 40)
    private String nom;
    private double latitude, longitude;
    private String description;
    @ManyToMany
    private Collection<Service> services;
    @Column(length = 100)
    private String adresse;
    private String horaire;
    private int noteGlobale;
    @OneToMany(mappedBy = "parcJardin")
    private Collection<Commentaire> commentaires;
    @OneToMany(mappedBy = "parcJardin")
    private Collection<Image> images;
}
