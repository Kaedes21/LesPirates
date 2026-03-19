package jeu.plateau.cases;

import jeu.pirates.Pirate;
import jeu.pirates.effets.EffetIvre;

public class CaseRhum extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
        pirate.gagnerCoeur(1);
        pirate.setEffet(new EffetIvre());
    }

    @Override
    public String getDescription(Pirate pirate) {
        return pirate.getNom() + " trouve une bouteille de rhum et la boit cul sec !\n" + "Il récupère un coeur.\n";
    }
}