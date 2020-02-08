package org.univ.parcJardin_backEnd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Lob
    private String description;
    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // pour ne pas retourner les services dans json
    private Collection<Service> services;
    @Column(length = 100)
    private String adresse;
    private String horaire;
    private double noteGlobale;
    @OneToMany(mappedBy = "parcJardin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Commentaire> commentaires;
    @OneToMany(mappedBy = "parcJardin")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<photo> photos;

    public ParcJardin(Type type, String nom, double latitude, double longitude, String description, Collection<Service> services, String adresse, String horaire, double noteGlobale) {
        this.type = type;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.services = services;
        this.adresse = adresse;
        this.horaire = horaire;
        this.noteGlobale = noteGlobale;
    }
}
