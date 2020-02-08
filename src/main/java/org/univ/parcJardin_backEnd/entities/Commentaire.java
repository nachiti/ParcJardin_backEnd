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
   // @ManyToOne
    private String nameUtilisateur;
    private int note;
    @Lob
    private String message;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ParcJardin parcJardin;

    public Commentaire(String nameUtilisateur, int note, String message, ParcJardin parcJardin) {
        this.nameUtilisateur = nameUtilisateur;
        this.note = note;
        this.message = message;
        this.parcJardin = parcJardin;
    }
}
