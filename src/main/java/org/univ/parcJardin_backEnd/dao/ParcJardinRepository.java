package org.univ.parcJardin_backEnd.dao;

import org.springframework.data.jpa.repository.Query;
import org.univ.parcJardin_backEnd.entities.Commentaire;
import org.univ.parcJardin_backEnd.entities.ParcJardin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.univ.parcJardin_backEnd.entities.Service;

import java.util.List;

@RepositoryRestResource
public interface ParcJardinRepository extends JpaRepository<ParcJardin,Long>{

    @Query("select p from ParcJardin p where upper(p.nom) like concat('%', upper(?1), '%') or upper(p.type) like concat('%', upper(?2), '%') or upper(p.adresse) like concat('%', upper(?3), '%')")
    public List<ParcJardin> findParcJardinByAllTypeOfKeyWord(String nom, String type, String adresse);

    @Query("select p from ParcJardin p where p.nom =?1")
    public ParcJardin findParcJardinByName(String nom);

    @Query("select p from ParcJardin p where p.id =?1")
    public ParcJardin findParcJardinById(Long id);

    @Query("select commentaires from ParcJardin p where p.id = ?1")
    public List<Commentaire> findAllCommentaireOfParcJardinById(Long id);


    /**recher  par nome
    @Query("select p from ParcJardin p where upper(p.nom) like concat('%', upper(?1), '%')")
    public List<ParcJardin> findParcJardinByName(String nom);*/

   /* @Query("select p from ParcJardin p " +
            "inner join parc_jardin_services jps on p.id = jps.parc_jardin_id " +
            "inner join service s on jps.services_id = s.id" +
            "where s.nom =?1 ")
    public List<ParcJardin> findParcJardinByServiceName(String nom);*/


    /*@Query("select distinct P from ParcJardin P where P.latitude=:latitude and P.longitude=:logitude")
    public ParcJardin trouverPJparLG(@Param("latitude") String latitude, @Param("logitude") String logitude);*/
}
