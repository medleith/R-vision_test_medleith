import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;
    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (v != null) {
            voitures.add(v);
        } else {
            throw new VoitureException("La voiture à ajouter est nulle.");
        }
    }

    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (v != null) {
            if (voitures.contains(v)) {
                voitures.remove(v);
            } else {
                throw new VoitureException("La voiture à supprimer n'existe pas dans la liste.");
            }
        } else {
            throw new VoitureException("La voiture à supprimer est nulle.");
        }
    }

    public Iterator<Voiture> iterateur()
    {
        return voitures.iterator();
    }
    public int size(){
        return voitures.size();
    }
    public void affiche() {
        for (Voiture voiture : voitures) {
            System.out.println(voiture.toString());
        }
    }
}