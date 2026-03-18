package pirates.effets;

import jeu.De;

public class EffetPacte implements IPirateEffet {
    @Override
    public int calculerDeplacement(int score, De de) {
        return score + de.lancerDe();
    }

    @Override
    public String getDescription() {
        return "Il est sous l'effet d'un pacte mystérieux.";
    }

    @Override
    public String getNom() {
        return "PACTE";
    }
}