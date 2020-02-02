package org.univ.parcJardin_backEnd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Utilisateur utilisateur;
    private double note;
    @Lob
    private String message;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ParcJardin parcJardin;

    public Commentaire(Utilisateur utilisateur, double note, String message, ParcJardin parcJardin) {
        this.utilisateur = utilisateur;
        this.note = note;
        this.message = message;
        this.parcJardin = parcJardin;
    }
}
