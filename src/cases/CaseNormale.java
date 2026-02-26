package cases;

import pirates.Pirate;

public class CaseNormale extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
        // aucun effet
    }

    @Override
    public String getDescription(Pirate pirate) {
        return "Rien de spécial sur cette case.\n";
    }
}