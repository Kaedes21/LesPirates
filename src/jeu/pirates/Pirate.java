package jeu.pirates;

import jeu.pirates.effets.EffetNormal;
import jeu.pirates.effets.IPirateEffet;
import jeu.pirates.pions.CouleurPion;
import jeu.pirates.pions.Pion;

public class Pirate {

    private final String nom;
    private int coeurs;
    private final Pion pion;
    private IPirateEffet effet;

    private static final int COEURS_MAX = 5;

    public Pirate(String nom, CouleurPion couleur) {
        this.nom = nom;
        this.coeurs = COEURS_MAX;
        this.pion = new Pion(couleur);
        this.effet = new EffetNormal();
    }

    public String getNom() { return nom; }
    public int getCoeurs() { return coeurs; }
    public Pion getPion() { return pion; }
    public IPirateEffet getEffet() { return effet; }

    public boolean estVivant() {
        return coeurs > 0;
    }
    
    public void perdreCoeur(int valeur) {
        if (valeur > 0) {
            coeurs = Math.max(0, coeurs - valeur);
        }
    }
    
    public void gagnerCoeur(int valeur) {
        if (valeur > 0) {
            coeurs = Math.min(COEURS_MAX, coeurs + valeur);
        }
    }

    public void setEffet(IPirateEffet effet) {
        this.effet = effet;
    }

    public void deplacerPion(int nouvellePosition) {
        pion.setPosition(nouvellePosition);
    }
}