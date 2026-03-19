package jeu.plateau.cases;

import jeu.pirates.Pirate;

public abstract class Case {

    public abstract void appliqueEffet(Pirate pirate);

    public abstract String getDescription(Pirate pirate);
}