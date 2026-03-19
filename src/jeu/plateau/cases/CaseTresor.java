package jeu.plateau.cases;

import jeu.pirates.Pirate;

public class CaseTresor extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
      // No effect
    }

    @Override
    public String getDescription(Pirate pirate) {
        return "Terre en vue ! " + pirate.getNom() + " a atteint le trésor !\n";
    }
}