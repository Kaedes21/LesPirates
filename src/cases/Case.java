package cases;

import pirates.Pirate;

public abstract class Case {

    public abstract void appliqueEffet(Pirate pirate);

    public abstract String getDescription(Pirate pirate);
}