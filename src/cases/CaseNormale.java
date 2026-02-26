package cases;

import pirates.Pirate;
import pirates.PirateEffet;

public class CaseNormale extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
    	pirate.setEffet(PirateEffet.NORMAL);
    }

    @Override
    public String getDescription(Pirate pirate) {
        return "Rien de spécial sur cette case.\n";
    }
}