package pirates.effets;

import jeu.De;

public class EffetNormal implements IPirateEffet {
    @Override
    public int calculerDeplacement(int score, De de) {
        return score;
    }

    @Override
    public String getDescription() {
        return "Tour normal.";
    }

    @Override
    public String getNom() {
        return "NORMAL";
    }
}
