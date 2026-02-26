package jeu;

import cases.Case;
import cases.CaseTresor;
import cases.CaseNormale;
import cases.CasePacte;
import cases.CaseRhum;

public class Plateau {

    private final Case[] cases = new Case[30];

    public Plateau() {
        attributionCases();
    }

    public int getNombreCases() {
        return cases.length;
    }

    private void attributionCases() {
        for (int i = 0; i < cases.length; i++) {
            double tirage = Math.random();

            if (tirage < 0.2) cases[i] = new CaseRhum();
            else if (tirage < 0.4) cases[i] = new CasePacte();
            else cases[i] = new CaseNormale();
        }
        
        cases[cases.length - 1] = new CaseTresor();
    }

    public Case getCase(int position) {
        if (position < 0) position = 0;
        if (position >= cases.length) position = cases.length - 1;
        return cases[position];
    }
}