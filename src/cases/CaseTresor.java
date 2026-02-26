package cases;

import pirates.Pirate;

public class CaseTresor extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
    	//Pas d'effet
    }

    @Override
    public String getDescription(Pirate pirate) {
        return "Terre en vue ! " + pirate.getNom() + " a atteint le trésor !\n";
    }
}