package org.univ.parcJardin_backEnd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<ParcJardin> getParcJardins() {
        return parcJardins;
    }

    public void setParcJardins(Collection<ParcJardin> parcJardins) {
        this.parcJardins = parcJardins;
    }

    @Column(length = 20)
    private String nom;
    @ManyToMany(mappedBy = "services")
    Collection<ParcJardin> parcJardins;

}
