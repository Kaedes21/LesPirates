package pirates.effets;

import jeu.De;

public interface IPirateEffet {
    String getDescription();
    String getNom();
    int calculerDeplacement(int scoreInitial, De deSupplementaire);
}