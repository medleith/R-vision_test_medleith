import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.vs = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
        for (ListVoitures voituresLouees : clientVoitureLoue.values()) {
            voituresLouees.supprimeVoiture(v);
        }
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures voituresLouees = clientVoitureLoue.get(cl);
            voituresLouees.ajoutVoiture(v);
        } else {
            ListVoitures voituresLouees = new ListVoitures();
            voituresLouees.ajoutVoiture(v);
            clientVoitureLoue.put(cl, voituresLouees);
        }
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures voituresLouees = clientVoitureLoue.get(cl);
            voituresLouees.supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSelectionnees = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresSelectionnees.add(v);
            }
        }
        return voituresSelectionnees;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures voituresLouees = entry.getValue();
            System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
            voituresLouees.affiche();
        }
    }





    public Map<Client, ListVoitures> triCodeCroissant() {
        TreeMap<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return Integer.compare(c1.getCode(), c2.getCode());
            }
        });
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }
    public Map<Client, ListVoitures> triNomCroissant() {
        TreeMap<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                    int compareNom = c1.getNom().compareTo(c2.getNom());
                if (compareNom == 0) {
                    return c1.getPrenom().compareTo(c2.getPrenom());
                }
                return compareNom;
            }
        });
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }

}
