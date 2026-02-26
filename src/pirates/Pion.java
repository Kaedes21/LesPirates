package pirates;

public class Pion {

    private final CouleurPion couleur;
    private int position;

    public Pion(CouleurPion couleur) {
        this.couleur = couleur;
        this.position = 1;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public CouleurPion getCouleur() {
        return couleur;
    }
}