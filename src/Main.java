import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Création d'une agence de location
        Agence agence = new Agence("AgenceLeith");

        // Création de voitures
        Voiture voiture1 = new Voiture(1, "Marque1", 100.0f);
        Voiture voiture2 = new Voiture(2, "Marque2", 150.0f);
        Voiture voiture3 = new Voiture(3, "Marque1", 120.0f);

        // Ajout des voitures à l'agence
        try {
            agence.ajoutVoiture(voiture1);
            agence.ajoutVoiture(voiture2);
            agence.ajoutVoiture(voiture3);
        } catch (VoitureException e) {
            System.err.println("Erreur lors de l'ajout de voitures: " + e.getMessage());
        }

        // Création de clients
        Client client1 = new Client(1, "Nom1", "Prenom1");
        Client client2 = new Client(2, "Nom2", "Prenom2");

        // Location de voitures par les clients
        try {
            agence.loueClientVoiture(client1, voiture1);
            agence.loueClientVoiture(client1, voiture2);
            agence.loueClientVoiture(client2, voiture3);
        } catch (VoitureException e) {
            System.err.println("Erreur lors de la location de voitures: " + e.getMessage());
        }

        // Affichage des voitures louées par les clients
        agence.afficheLesClientsEtLeursListesVoitures();

        // Retour de voitures par les clients
        try {
            agence.retourClientVoiture(client1, voiture1);
        } catch (VoitureException e) {
            System.err.println("Erreur lors du retour de voitures: " + e.getMessage());
        }

        // Affichage des voitures louées après le retour
        System.out.println("Voitures louées après le retour :");
        agence.afficheLesClientsEtLeursListesVoitures();

        // Sélection de voitures selon un critère
        Critere critere = new CritereMarque("Marque1");
        List<Voiture> voituresSelonCritere = agence.selectVoitureSelonCritere(critere);
        System.out.println("Voitures selon le critère :");
        for (Voiture v : voituresSelonCritere) {
            System.out.println(v.toString());
        }

        // Ensemble des clients loueurs
        Set<Client> clientsLoueurs = agence.ensembleClientsLoueurs();
        System.out.println("Clients ayant loué des voitures :");
        for (Client c : clientsLoueurs) {
            System.out.println(c.toString());
        }

        // Collection de voitures louées
        Collection<ListVoitures> voituresLouees = agence.collectionVoituresLouees();
        System.out.println("Listes de voitures louées :");
        for (ListVoitures lv : voituresLouees) {
            lv.affiche();
        }
        // Tri des clients par code
        Map<Client, ListVoitures> clientsTriCode = agence.triCodeCroissant();
        System.out.println("Clients triés par code :");
        for (Client c : clientsTriCode.keySet()) {
            System.out.println(c.toString());
        }

        // Tri des clients par nom
        Map<Client, ListVoitures> clientsTriNom = agence.triNomCroissant();
        System.out.println("Clients triés par nom :");
        for (Client c : clientsTriNom.keySet()) {
            System.out.println(c.toString());
        }
        Map<Client, ListVoitures> clientsTriesParCode = agence.triCodeCroissant();

        System.out.println("Clients triés par code croissant :");
        for (Map.Entry<Client, ListVoitures> entry : clientsTriesParCode.entrySet()) {
            System.out.println(entry.getKey());
        }



    }
}
