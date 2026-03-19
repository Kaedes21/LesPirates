package jeu.pirates.effets;

import jeu.De;

public interface IPirateEffet {
	
    public String getDescription();
    public int calculerDeplacement(int scoreInitial, De deSupplementaire);
    
}