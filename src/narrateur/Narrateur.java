package narrateur;

import cases.Case;
import pirates.Pirate;

public class Narrateur implements IJournalDeBord {

    private final String nom;

    public Narrateur(String nom) {
        this.nom = nom;
    }

    @Override
    public String annoncerDebutJeu(Pirate joueur1, Pirate joueur2) {

        return "Yaaaaargh ! Je suis " + nom + " et je présente la course.\n" + joueur1.getNom() + " affronte " + joueur2.getNom() + " !\n";
    }

    @Override
    public String annoncerDebutTour(Pirate joueur, int tour) {

        String texte = "\nTour " + tour + " - Au tour de " + joueur.getNom() + " (" + joueur.getCoeurs() + " coeurs) (position : " +joueur.getPion().getPosition() +").\n";

        switch (joueur.getEffet()) {
            case PACTE:
                texte += "Il est sous l'effet d'un pacte mystérieux.\n";
                break;
            case IVRE:
                texte += "Il tangue encore sous l'effet du rhum.\n";
                break;
            default:
                texte += "Tour normal.\n";
        }

        return texte;
    }

    @Override
    public String annoncerLancementDes(Pirate joueur, int valeur) {
        return joueur.getNom() + " lance les dés : " + valeur + ".\n";
    }

    @Override
    public String annoncerDeplacement(Pirate joueur) {
        return "Le pion " + joueur.getPion().getCouleur() + " avance.\n";
    }

    @Override
    public String annoncerArriverCase(Pirate joueur, Case caseArrivee) {

        return "Le pion arrive sur la case " + joueur.getPion().getPosition() + ".\n" + caseArrivee.getDescription(joueur);
    }

    @Override
    public String annoncerGagnant(Pirate joueur) {
        return "Le vainqueur est " + joueur.getNom() + " !";
    }
    
    @Override
    public String annoncerKO(Pirate pirate) {
        return pirate.getNom() + " s'étale comme une crepe , il n'a plus d'énergie...\n";
    }
}