package jeu.pirates.effets;

import jeu.De;

public class EffetPacte implements IPirateEffet {
	
    @Override
    public int calculerDeplacement(int score, De de) {
        return score + de.lancerDe();
    }

    @Override
    public String getDescription() {
        return "Le pirate est sous l'effet d'un pacte mystérieux.";
    }

}