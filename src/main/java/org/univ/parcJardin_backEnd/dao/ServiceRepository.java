package org.univ.parcJardin_backEnd.dao;

import org.springframework.data.jpa.repository.Query;
import org.univ.parcJardin_backEnd.entities.ParcJardin;
import org.univ.parcJardin_backEnd.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ServiceRepository extends JpaRepository<Service,Long>{

    @Query("select s from Service s where s.id =?1")
    public List<Service> findServiceById(Long id);


    @Query("select s.parcJardins from Service s where s.nom =?1")
    public List<ParcJardin> findParcJardinFromServiceByNameService(String nom);

}
