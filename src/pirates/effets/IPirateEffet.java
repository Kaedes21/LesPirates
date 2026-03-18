package pirates.effets;

import jeu.De;

public interface IPirateEffet {
    public String getDescription();
    public String getNom();
    public int calculerDeplacement(int scoreInitial, De deSupplementaire);
}