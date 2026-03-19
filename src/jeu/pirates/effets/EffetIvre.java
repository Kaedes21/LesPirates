package jeu.pirates.effets;

import jeu.De;

public class EffetIvre implements IPirateEffet {
	
    @Override
    public int calculerDeplacement(int score, De de) {
        return -score;
    }

    @Override
    public String getDescription() {
        return "Le pirate tangue encore sous l'effet du rhum.";
    }

}