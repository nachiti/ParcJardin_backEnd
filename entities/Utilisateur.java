package com.univ.parcJardin_Spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String pseudo;
    @Column(length = 40)
    private String password;
    private String photo;
    @Column(length = 40)
    private String mail;
    @OneToMany(mappedBy ="utilisateur")
    private Collection<Commentaire> commentaires;
}
