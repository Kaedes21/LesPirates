package jounaldebord;

import cases.Case;
import pirates.Pirate;

public class Narrateur implements IJournalDeBord {

    private final String nom;

    public Narrateur(String nom) {
        this.nom = nom;
    }

    @Override
    public String annoncerDebutJeu(Pirate pirate1, Pirate pirate2) {

        return "Yaaaaargh ! Je suis " + nom + " et je présente la course.\n" + pirate1.getNom() + " affronte " + pirate2.getNom() + " !\n";
    }

    @Override
    public String annoncerDebutTour(Pirate pirate, int tour) {

        String texte = "\nTour " + tour + " - Au tour de " + pirate.getNom() + " (" + pirate.getCoeurs() + " coeurs) (position actuelle: " +pirate.getPion().getPosition() +").\n";

        texte += pirate.getEffet().getDescription();

        return texte;
    }

    @Override
    public String annoncerLancementDes(int valeur) {
        return "Les dés sont lancés ! Résultat : " + valeur + ".\n";
    }

    @Override
    public String annoncerDeplacement(Pirate pirate) {
        return "Le pion " + pirate.getPion().getCouleur() + " avance.\n";
    }

    @Override
    public String annoncerArriverCase(Pirate pirate, Case caseArrivee) {

        return "Le pirate arrive sur la case " + pirate.getPion().getPosition() + ".\n" + caseArrivee.getDescription(pirate);
    }

    @Override
    public String annoncerGagnant(Pirate pirate) {
        return "Le vainqueur est " + pirate.getNom() + " !";
    }
    
    @Override
    public String annoncerKO(Pirate pirate) {
        return pirate.getNom() + " s'étale comme une crepe , il n'a plus d'énergie...\n";
    }
}