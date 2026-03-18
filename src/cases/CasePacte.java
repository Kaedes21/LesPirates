package cases;

import pirates.Pirate;
import pirates.effets.EffetPacte;

public class CasePacte extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
        pirate.perdreCoeur(2);
        pirate.setEffet(new EffetPacte());
    }

    @Override
    public String getDescription(Pirate pirate) {
        return pirate.getNom() + " conclut un pacte avec un esprit des mers !\n" + "Il perd 2 coeurs mais prépare un lancer renforcé.\n";
    }
}