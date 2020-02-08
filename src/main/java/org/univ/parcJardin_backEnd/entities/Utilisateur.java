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
    /*@OneToMany(mappedBy ="utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Commentaire> commentaires;*/

    public Utilisateur(String pseudo, String password, String photo, String mail, Collection<Commentaire> commentaires) {
        this.pseudo = pseudo;
        this.password = password;
        this.photo = photo;
        this.mail = mail;
       // this.commentaires = commentaires;
    }
}
