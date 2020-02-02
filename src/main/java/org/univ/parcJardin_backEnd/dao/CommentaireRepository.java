package org.univ.parcJardin_backEnd.dao;

import org.springframework.data.jpa.repository.Query;
import org.univ.parcJardin_backEnd.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.univ.parcJardin_backEnd.entities.Utilisateur;

import java.util.List;

@RepositoryRestResource
public interface CommentaireRepository extends JpaRepository<Commentaire,Long>{

    @Query("select c.utilisateur from commentaire c where c.id = ?1")
    public List<Utilisateur> findUtilisateurOfCommentaire(Long id);
}
