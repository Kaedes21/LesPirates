package jeu.pirates.effets;

import jeu.De;

public class EffetIvre implements IPirateEffet {
    @Override
    public int calculerDeplacement(int score, De de) {
        return -score;
    }

    @Override
    public String getDescription() {
        return "Il tangue encore sous l'effet du rhum.";
    }

    @Override
    public String getNom() {
        return "IVRE";
    }
}