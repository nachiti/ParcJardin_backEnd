package org.univ.parcJardin_backEnd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.univ.parcJardin_backEnd.dao.CommentaireRepository;
import org.univ.parcJardin_backEnd.dao.ParcJardinRepository;
import org.univ.parcJardin_backEnd.dao.ServiceRepository;
import org.univ.parcJardin_backEnd.dao.UtilisateurRepository;
import org.univ.parcJardin_backEnd.entities.Commentaire;
import org.univ.parcJardin_backEnd.entities.ParcJardin;
import org.univ.parcJardin_backEnd.entities.Utilisateur;

import javax.validation.Valid;
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
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;

    /**
     * retourn toues les parcjardin
     * @return
     */
    @GetMapping("/parcjardins")
    public List<ParcJardin> getAllParcJardin(){
        return parcJardinRepository.findAll();
    }

    /**
     * Recherche par nom ou type ou adresse
     * @param nom
     * @param type
     * @param adresse
     * @return
     */
    @GetMapping("/parcjardins/{q}")
    public List<ParcJardin> getParcJardinnSearch(@PathVariable(name = "q") String nom,@PathVariable(name = "q") String type,@PathVariable(name = "q") String adresse){
        return parcJardinRepository.findParcJardinByAllTypeOfKeyWord(nom,type,adresse);
    }

    @GetMapping("/parcjardin/{nom}")
    public ParcJardin getParcJardinnByName(@PathVariable(name = "nom") String nom){
        return parcJardinRepository.findParcJardinByName(nom);
    }

    @GetMapping("/parcjardin/parcjardinId/{id}")
    public ParcJardin getParcJardinById(@PathVariable(name = "id") Long id){
        return parcJardinRepository.findParcJardinById(id);
    }


    @GetMapping("/services/{nom}/parcjardins")
    public List<ParcJardin> getParcJardinByService(@PathVariable(name = "nom") String nameService){
        return serviceRepository.findParcJardinFromServiceByNameService(nameService);
    }

    @GetMapping("/parcjardin/{id}/commentaires")
    public List<Commentaire> getAllCommentaireOfParcJardinById(@PathVariable(name = "id") Long id){
        return parcJardinRepository.findAllCommentaireOfParcJardinById(id);
    }

    /*@GetMapping("/commentaires")
    public List<Commentaire> getAllcommentaires(){
        return commentaireRepository.findAll();
    }*/

    /**
     * Post commentaire
     */
   /* @GetMapping(value = "/parcjardin/userpostcommentaire/{idPJ}/{name}/{nbrEtoile}/{commentaire}")
    public void postCommentaire(@PathVariable("id") Long id, @PathVariable("name") String name,
                                       @PathVariable("nbrEtoile") int nbrEtoile, @PathVariable("commentaire") String commentaire){
        commentaireRepository.addCommeantaire();
    }*/

    @GetMapping(value = "/commentaires/{nameUtilisateur}")
    public List<Commentaire> getUtilisateurOfCommentaire(@PathVariable(name = "nameUtilisateur")String nameUtilisateur ){
        return commentaireRepository.findCommentaireByNameUser(nameUtilisateur);
    }

    /**
     * ajouter un commentaire pour un parcjardin de id = idpj
     * @param id
     * @param nameUtilisateur
     * @param note
     * @param message
     * @return
     */

    @PostMapping(value = "/addcommentaire/{idpj}/{nameUtilisateur}/{note}/{message}")
    public Commentaire addNewCommentaire(@PathVariable(value = "idpj")long id,@PathVariable(value = "nameUtilisateur")String nameUtilisateur,@PathVariable(value = "note")int note,@PathVariable(value = "message")String message ){
        Commentaire commentaire = new Commentaire();
        commentaire.setMessage(message);
        commentaire.setNote(note);
        commentaire.setNameUtilisateur(nameUtilisateur);
        return parcJardinRepository.findById(id).map(parcJardin -> {
            commentaire.setParcJardin(parcJardin);
            return commentaireRepository.save(commentaire);
        }).orElseThrow(() -> new ResourceNotFoundException("parcjardin ID " + id + " not found"));
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
