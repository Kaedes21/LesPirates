package cases;

import pirates.Pirate;

public class CaseRhum extends Case {

    @Override
    public void appliqueEffet(Pirate pirate) {
        pirate.gagnerCoeur(1);
    }

    @Override
    public String getDescription(Pirate pirate) {
        return pirate.getNom() +
               " trouve une bouteille de rhum et la boit cul sec !\n" +
               "Il récupère un coeur.\n";
    }
}