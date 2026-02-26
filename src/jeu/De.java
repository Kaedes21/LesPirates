package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class De {
	private int valeur;
	
	private Random random;
	
	public De(int valeur)
	{
		this.valeur = valeur;
		
		try {
	        random = SecureRandom.getInstanceStrong();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public int lancerDe()
	{
		return random.nextInt(1,valeur);
	}
}
