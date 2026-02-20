package jeu;

import jeu.Pion.CouleurPion;

public class Joueur {

    private String nom;
    private int coeurs;
    private Pion pion;
    private Plateau plateau;
    private JoueurEffet effet;
    private static final int COEURS_MAX = 5;

    public Joueur(String nom, CouleurPion couleur, Plateau plateau) {
        this.nom = nom;
        this.coeurs = COEURS_MAX;
        this.plateau = plateau;
        this.pion = new Pion(couleur, plateau);
        this.effet = JoueurEffet.NORMAL;
    }

    public String getNom() { return nom; }
    public int getCoeurs() { return coeurs; }
    public Pion getPion() { return pion; }

    public boolean estVivant() { return coeurs > 0; }

    public void perdreCoeur(int valeur) {
        if (valeur <= 0) return;
        coeurs -= valeur;
        if (coeurs < 0) coeurs = 0;
    }

    public void gagnerCoeur(int valeur) {
        if (valeur <= 0) return;
        coeurs += valeur;
        if (coeurs > COEURS_MAX) coeurs = COEURS_MAX;
    }
    
    public JoueurEffet getEffet()
    {
    	return effet;
    }
    
    public int lancerDes(Plateau plateau) { return plateau.getDe1().lancerDe() + plateau.getDe2().lancerDe(); }
    public int lancerDeUnique(Plateau plateau) { return plateau.getDe1().lancerDe();}
    
    public void setEffet(JoueurEffet effet) {
    	this.effet= effet;
    }
    public void deplacerPion(int nbCases) {
        if (!estVivant()) return;

        int position = pion.getPosition();
        int derniereCase = plateau.getNombreCases(); // 30
        
        position += nbCases;

        while (position > derniereCase) {
            position = derniereCase - (position - derniereCase);
        }

        if (position > derniereCase) position = derniereCase;
        if (position < 1) position = 1;

        pion.setPosition(position);

        Case caseArrivee = plateau.getCase(position - 1);
        if (caseArrivee != null) {
            caseArrivee.appliqueEffet(this);
        }
    }
}
