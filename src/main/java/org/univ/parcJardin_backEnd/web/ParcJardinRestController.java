package org.univ.parcJardin_backEnd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.parcJardin_backEnd.dao.ParcJardinRepository;
import org.univ.parcJardin_backEnd.dao.UtilisateurRepository;
import org.univ.parcJardin_backEnd.entities.ParcJardin;
import org.univ.parcJardin_backEnd.entities.Utilisateur;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ParcJardinRestController {

    @Autowired
    private ParcJardinRepository parcJardinRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/ListParcJardins")
    public List<ParcJardin> parcJardins(){
        return parcJardinRepository.findAll();
    }

    @GetMapping(value = "/profilUtilisateur/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] profilUtilisateur(@PathVariable(name = "id") Long id) throws IOException {
        Utilisateur utilisateur = utilisateurRepository.findById(id).get();
        String nom = utilisateur.getPhoto();
        File file = new File(System.getProperty("user.home")+"/parcJardins/profils/"+nom);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

/*    @GetMapping(value = "/")
    public List<ParcJardin> getAllparcJardinByService(){

    }*/
}
