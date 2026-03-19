package jeu.plateau;

import java.util.Random;

import jeu.plateau.cases.Case;
import jeu.plateau.cases.CaseNormale;
import jeu.plateau.cases.CasePacte;
import jeu.plateau.cases.CaseRhum;
import jeu.plateau.cases.CaseTresor;

public class Plateau {

    private final Case[] cases = new Case[30];
    private final Random random = new Random();

    public Plateau() {
        attributionCases();
    }

    public int getNombreCases() {
        return cases.length;
    }
    
    private void attributionCases() {
        for (int i = 0; i < cases.length; i++) {
            double tirage = random.nextDouble();

            if (tirage < 0.2) {
                cases[i] = new CaseRhum();
            } else if (tirage < 0.4) {
                cases[i] = new CasePacte();
            } else {
                cases[i] = new CaseNormale();
            }
        }
        cases[cases.length - 1] = new CaseTresor();
    }

    public Case getCase(int position) {
        int index = position;
        if (index < 0) {
            index = 0;
        }
        if (index >= cases.length) {
            index = cases.length - 1;
        }
        return cases[index];
    }
}