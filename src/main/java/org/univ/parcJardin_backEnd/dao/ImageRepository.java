package org.univ.parcJardin_backEnd.dao;

import org.univ.parcJardin_backEnd.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ImageRepository extends JpaRepository<Image,Long>{

}
