package cases;

import pirates.Pirate;
import pirates.effets.EffetNormal;
public class CaseNormale extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
    	pirate.setEffet(new EffetNormal());
    }

    @Override
    public String getDescription(Pirate pirate) {
        return "Rien de spécial sur cette case.\n";
    }
}