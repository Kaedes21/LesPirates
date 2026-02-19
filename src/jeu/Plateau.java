package jeu;

public class Plateau {

    private Case[] cases = new Case[30];
    private De de1 = new De(6);
    private De de2 = new De(6);

    public Plateau() { attributionCases(); }

    public int lancerDes() { return de1.lancerDe() + de2.lancerDe(); }

    public int getNombreCases() { return cases.length; }

    private void attributionCases() {
        for (int i = 0; i < cases.length; i++) {
            double tirage = Math.random();
            if (tirage < 0.1) cases[i] = new CaseRhum(i);
            else if (tirage < 0.2) cases[i] = new CasePacte(i);
            else cases[i] = new Case(i);
        }
    }

    public Case getCase(int position) {
        if (position < 0) position = 0;
        if (position >= cases.length) position = cases.length - 1;
        return cases[position];
    }
}
