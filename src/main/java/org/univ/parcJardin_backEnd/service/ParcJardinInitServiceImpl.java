package org.univ.parcJardin_backEnd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.univ.parcJardin_backEnd.dao.*;
import org.univ.parcJardin_backEnd.entities.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class ParcJardinInitServiceImpl implements IParcJardinIntService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ParcJardinRepository parcJardinRepository;

    @Override
    public void initServices() {
        Stream.of("MONUMENT", "CAFETERIA", "ETUDE", "SPORT", "JEUX", "Lac").forEach(serviceName -> {
            org.univ.parcJardin_backEnd.entities.Service service = new org.univ.parcJardin_backEnd.entities.Service();
            service.setNom(serviceName);
            serviceRepository.save(service);
        });
    }
    @Override
    public void initParcJardins() {
        List<org.univ.parcJardin_backEnd.entities.Service> services = serviceRepository.findAll();
        ParcJardin parc1 = new ParcJardin(Type.PARC,"Barbieux",50.678121,3.163765,"Le parc Barbieux est situé dans " +
                "la commune de Roubaix faisant partie de Lille Métropole. C'est un parc remarquable par la présence de plus" +
                " de 60 essences d'arbres. Il s’étend sur 1,5 kilomètre avec une surface de 34 hectares.",
                new ArrayList<org.univ.parcJardin_backEnd.entities.Service>(Arrays.asList(services.get(1),services.get(2),services.get(4))),
                "Avenue le Nôtre, 59100 Roubaix, France", "Ouvert 24h/24",4.5);
        parcJardinRepository.save(parc1);

        ParcJardin jardin1 = new ParcJardin(Type.JARDIN,"Jardin des Géants",50.643433,3.074955,
                "Le jardin des Géants est un jardin ouvert au public, situé à La Madeleine, dans le département" +
                        " du Nord, près des bâtiments de Lille Métropole, auquel il appartient. Ce parc a été construit en 2003.",
                new ArrayList<org.univ.parcJardin_backEnd.entities.Service>(Arrays.asList(services.get(1),services.get(2),services.get(3))),
                "1 Rue de la Communauté, 59110 La Madeleine", "09:00–21:00",3.6);
        parcJardinRepository.save(jardin1);

        ParcJardin parc2 = new ParcJardin(Type.PARC,"Parc Heron",50.637372,3.146333,
                "Le parc du Héron est l'un des parcs de Villeneuve-d'Ascq, d'une superficie de 110 ha. " +
                        "Une partie est classée sous la forme de la réserve naturelle régionale du Héron.",
                services,
                "Chemin du Grand Marais, 59650 Villeneuve-d'Ascq",
                "Ouvert 24h/24",5);
        parcJardinRepository.save(parc2);

        ParcJardin parc3 = new ParcJardin(Type.PARC,"Parc Jean-Baptiste Lebas",50.637372,3.146333,
                "Le parc Jean-Baptiste Lebas aménagé à partir de 2004 sur un boulevard ouvert en 1865 est situé " +
                        "sur le grand axe de communication historique de Lille vers le Sud",
                services,
                "21 Boulevard Jean-Baptiste Lebas, 59000 Lille",
                        "07:30–21:00",4.9);
        parcJardinRepository.save(parc3);

        ParcJardin jardin2 = new ParcJardin(Type.JARDIN,"Plaine de la Poterne",50.649435,3.057065,
                "Située à l’extrême nord du Vieux-Lille, cette vaste plaine naturelle de 8 ha, traversée par " +
                        "le cour d'eau de la tortue, est un site privilégié pour les balades nature.",
                new ArrayList<org.univ.parcJardin_backEnd.entities.Service>(Arrays.asList(services.get(1),services.get(2),services.get(3))),
                "1 Rue de la Communauté, 59110 La Madeleine", "09:00–21:00",5);
        parcJardinRepository.save(jardin2);
    }

/*    @Override
    public void initUtilisateurs() {
        Stream.of("Bob", "Alice", "Greg","Lucile","Poline","Philipe").forEach(utilisateurName -> {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPseudo(utilisateurName);
            utilisateur.setMail(utilisateurName + "@test.fr");
            utilisateur.setPassword("password");
            utilisateur.setPhoto(utilisateurName+".jpg");
            utilisateurRepository.save(utilisateur);
        });
    }*/

    @Override
    public void initCommentaires() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        List<ParcJardin> parcJardins = parcJardinRepository.findAll();

        Commentaire commentaire1 = new Commentaire(utilisateurs.get(0),5,"Un parc très agréable. Étendu dans une belle" +
                " longueur et traversé par l'eau d'un bout à l'autre cela " +
                "donne une belle énergie à ce lieu. Des arbres immenses rendent cet espace paisible au cœur de la ville.",
                parcJardins.get(0));
        commentaireRepository.save(commentaire1);

        Commentaire commentaire2 = new Commentaire(utilisateurs.get(1),4.9,"Magnifique parc ou il fait bon" +
                " se balader ou se poser jolis bassins avec canards et autres oiseaux. Possibilité " +
                "de pique nuque ou de faire du sport un lieu parfait pour celibataire ou en famille. ." +
                "une petite buvette serait la bienvenue..;-)",
                parcJardins.get(0));
        commentaireRepository.save(commentaire2);

        Commentaire commentaire3 = new Commentaire(utilisateurs.get(2),4.6,"Très beau parc, tout en longueur, avec des arbres magnifiques et de " +
                "toutes les couleurs (j'y suis allée" +
                " en automne). C'était très calme et et c'est très sympathique pour une balade d'une heure",
                parcJardins.get(0));
        commentaireRepository.save(commentaire3);

        Commentaire commentaire4 = new Commentaire(utilisateurs.get(3),5,"Toujours aussi joli parc !!!\n" +
                "Je dirai même encore plus beau beau que dans mes souvenirs... grâce à la volonté de \"laisser faire" +
                " la nature\" tout en la maîtrisant savamment...notamment sur toutes les berges !!!\n" +
                "La faune et la flore s'en trouvent plus naturelles !!!\n" +
                "Ça me plaît beaucoup...\n" +
                "Bonnes promenades à tout le monde !!!",
                parcJardins.get(0));
        commentaireRepository.save(commentaire4);

                //------------------------------------------------------------------------------------------------------
        Commentaire commentaire5 = new Commentaire(utilisateurs.get(2),5, "Ce jardin n'est pas très grand mais il est fort bien aménagé. C'est une oasis de calme, de verdure, de Géants " +
                "et autres sculptures en bordure de périphériques ou l'on peu aussi se désaltérer si le bar est ouvert. " +
                "Les étendues d'eau et les espaces un peu isolés bien aménagés sont propices au calme, on peut s'y " +
                "détendre en observant les canards.",
                parcJardins.get(1));
        commentaireRepository.save(commentaire5);

        Commentaire commentaire6 = new Commentaire(utilisateurs.get(4),5,"Un voyage dépaysant au royaume des jardins.\n" +
                "Que dire sinon que ce jardin est fabuleux.\n" +
                "Des thématiques originales, un jardin pour les enfants et pour les parents. Une scénographie soignée," +
                " des idées de mise en scène. Une restauration Bio et locale. \n" +
                "Alors prenez le temps de prendre le temps.",
                parcJardins.get(1));
        commentaireRepository.save(commentaire6);

        Commentaire commentaire7 = new Commentaire(utilisateurs.get(5),5,"Adorable balade, des statues végétales, Un bar intérieur extérieur .. Des petits plans d'eau... Le chien adore la balade!",
                parcJardins.get(1));
        commentaireRepository.save(commentaire7);

        Commentaire commentaire8 = new Commentaire(utilisateurs.get(1),5,"Tres beau lieux et très calme en tous cas il y a aussi des banc pour s'assoir et aussi un petit coin bar " +
                "et restauration ce qui permet de s areeter si on a soif ou faim et le jardin et très bien entretenu avec" +
                " des belle réalisation en tous j ai vraiment apprécié le calme du jardin aussi",
                parcJardins.get(1));
        commentaireRepository.save(commentaire8);

                //------------------------------------------------------------------------------------------------------

        Commentaire commentaire9 = new Commentaire(utilisateurs.get(0),5,"Bon moment pour se promener sous le soleil.",
                parcJardins.get(2));
        commentaireRepository.save(commentaire9);

        Commentaire commentaire10 = new Commentaire(utilisateurs.get(2),5,"Très bel endroit, jolies promenades à faire et quelque soit la saison. Centre équestre, manèges et vente" +
                " de sucreries sur place",
                parcJardins.get(2));
        commentaireRepository.save(commentaire10);

        Commentaire commentaire11 = new Commentaire(utilisateurs.get(1),4.9,"Lieu calme avec parking. Parfait pour un jogging ou une ballade.",
                parcJardins.get(2));
        commentaireRepository.save(commentaire11);

        Commentaire commentaire12 = new Commentaire(utilisateurs.get(3),5, "Jolie parc et grand, permet de faire une balade",
                parcJardins.get(2));
        commentaireRepository.save(commentaire12);

                //------------------------------------------------------------------------------------------------------
        Commentaire commentaire13 = new Commentaire(utilisateurs.get(1),3,  "Personnel de \"surveillance\" peux aimable !!! 2 étoiles car l'on peux croisé de super personne et y" +
                " passé d'agréables moments.\n" +
                "Mais il faut pensé a modifié la qualité d'approche professionnel du personnel...",
                parcJardins.get(3));
        commentaireRepository.save(commentaire13);

        Commentaire commentaire14 = new Commentaire(utilisateurs.get(0),5,   "Parc très bien situé et agréable avec pas mal de jeux pour les enfants de 2 à 10 ans avec de grandes étendues " +
                "d'herbe pour les amateurs de ballon ou autre jeu d'extérieur. Juste en face de la gare st sauveur. " +
                "Ambiance bon enfant assurée ;-)",
                parcJardins.get(3));
        commentaireRepository.save(commentaire14);

                //------------------------------------------------------------------------------------------------------
        Commentaire commentaire15 = new Commentaire(utilisateurs.get(3),1,   "Décharge, ordures en tout genre, comment peut-on laissez faire ça ,  que font les villes de Saint André et " +
                "de Lille ???  HONTEUX quel dommage et quelle mauvaise image !",
                parcJardins.get(4));
        commentaireRepository.save(commentaire15);

        Commentaire commentaire16 = new Commentaire(utilisateurs.get(4),3,"Petit parc agréable mais manque un peut d'entretien",
                parcJardins.get(4));
        commentaireRepository.save(commentaire16);

    }

    @Override
    public void initImages() {
        List<ParcJardin> parcJardins = parcJardinRepository.findAll();
        Stream.of("barbieux1.jpg", "barbieux2.jpg", "barbieux3.jpg", "barbieux4.jpg", "barbieux5.jpg"
        ).forEach(imageName -> {
            Photo image = new Photo();
            image.setNom(imageName);
            image.setParcJardin(parcJardins.get(0));
            imageRepository.save(image);
        });

        Stream.of("geants1.jpg", "geants2.jpg", "geants3.jpg", "geants4.jpg"
        ).forEach(imageName -> {
            Photo image = new Photo();
            image.setNom(imageName);
            image.setParcJardin(parcJardins.get(1));
            imageRepository.save(image);
        });

        Stream.of("heron1.jpg", "heron2.jpg", "heron3.jpg", "heron4.jpg"
        ).forEach(imageName -> {
            Photo image = new Photo();
            image.setNom(imageName);
            image.setParcJardin(parcJardins.get(2));
            imageRepository.save(image);
        });

        Stream.of("Jean-Baptiste1.jpg", "Jean-Baptiste2.jpg", "Jean-Baptiste3.jpg", "Jean-Baptiste4.jpg"
        ).forEach(imageName -> {
            Photo image = new Photo();
            image.setNom(imageName);
            image.setParcJardin(parcJardins.get(3));
            imageRepository.save(image);
        });

        Stream.of("La-plaine-de-la-Poterne1.jpg", "La-plaine-de-la-Poterne2.jpg", "La-plaine-de-la-Poterne3.jpg"
        ).forEach(imageName -> {
            Photo image = new Photo();
            image.setNom(imageName);
            image.setParcJardin(parcJardins.get(4));
            imageRepository.save(image);
        });

    }
}
