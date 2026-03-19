package jounaldebord;

import java.util.Scanner;

import jeu.pirates.Pirate;
import jeu.plateau.cases.Case;

public class Narrateur implements IJournalDeBord {

    private final String nom;
    private final Scanner scanner;
    
    public Narrateur(String nom) {
        this.nom = nom;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String annoncerDebutJeu(Pirate pirate1, Pirate pirate2) {
        String texte = "\n*****************************************************\n";
        texte += "  BIENVENUE SUR LA COURSE DES PIRATES !\n";
        texte += "  Je suis " + nom + ", votre humble narrateur.\n";
        texte += "  Aujourd'hui : " + pirate1.getNom() + " affronte " + pirate2.getNom() + " !\n";
        texte += "*****************************************************\n";
        return texte;
    }

    @Override
    public String annoncerDebutTour(Pirate pirate, int tour) {
        int pv = pirate.getCoeurs();
        String jaugeVie = "♥".repeat(pv) + "♡".repeat(5 - pv);
        
        String texte = "\n=====================================================\n";
        texte += " TOUR " + tour + " | " + pirate.getNom()  + " | " + jaugeVie + " (" + pv + "/5)\n";
        texte += "-----------------------------------------------------\n";
        texte += " ETAT     : " + pirate.getEffet().getDescription() + "\n";
        texte += " POSITION : Case " + pirate.getPion().getPosition() + "\n";
        return texte;
    }

    @Override
    public String annoncerLancementDes(int valeur) {
        return " >>> [Résultat Dés] : " + valeur + "\n";
    }

    @Override
    public String annoncerDeplacement(Pirate pirate) {
        return " ~~~ Le pion " + pirate.getPion().getCouleur() + " glisse sur les flots...\n";
    }

    @Override
    public String annoncerArriverCase(Pirate pirate, Case caseArrivee) {
        String texte = "-----------------------------------------------------\n";
        texte += " ARRIVEE : Case " + pirate.getPion().getPosition() + "\n";
        texte += " EVENT   : " + caseArrivee.getDescription(pirate);
        texte += "=====================================================";
        return texte;
    }

    @Override
    public String annoncerGagnant(Pirate pirate) {
        String texte = "\n#####################################################\n";
        texte += "      VICTOIRE DE " + pirate.getNom() + " !\n";
        texte += "      Il repart avec le trésor et la gloire !\n";
        texte += "#####################################################\n";
        return texte;
    }
    
    @Override
    public String annoncerKO(Pirate pirate) {
        String jaugeVide = "♡♡♡♡♡ (0/5)";
        
        String texte = "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
        texte += "  MALHEUR : " + pirate.getNom() + " s'étale comme une crêpe !\n";
        texte += "  ÉTAT     : " + jaugeVide + "\n";
        texte += "  Il n'a plus une once d'énergie pour continuer...\n";
        texte += "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
        
        return texte;
    }

    @Override
    public void attendreEntree() {
        System.out.println("\n[Appuyez sur Entrée pour continuer...]");
        scanner.nextLine();
    }

    @Override
    public String demanderNomPirate(int numero) {
        System.out.print("Hé oh ! Matelot n°" + numero + ", décline ton identité : ");
        return scanner.nextLine();
    }

    @Override
    public void fermer() {
        scanner.close();
    }
}