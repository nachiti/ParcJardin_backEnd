package org.univ.parcJardin_backEnd.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.univ.parcJardin_backEnd.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.univ.parcJardin_backEnd.entities.Utilisateur;

import java.util.List;

@RepositoryRestResource
public interface CommentaireRepository extends JpaRepository<Commentaire,Long>{

    @Query("select c from Commentaire c where c.nameUtilisateur = ?1")
    public List<Commentaire> findCommentaireByNameUser(String nameUtilisateur);

   /* @Modifying
    @Query("insert into Commentaire (nameUtilisateur,note,message)")
    public int modifyingQueryInsertPerson( @Param("nameUtilisateur")String nameUtilisateur,@Param("note")String note, @Param("message")String message);*/


}
