package jeu;

import java.util.Random;
import cases.Case;
import cases.CaseTresor;
import cases.CaseNormale;
import cases.CasePacte;
import cases.CaseRhum;

public class Plateau {

    private final Case[] cases = new Case[30];
    private final Random random = new Random();

    public Plateau() {
        attributionCases();
    }

    public int getNombreCases() {
        return cases.length;
    }
    
    /**
     *  Positionne les cases aléatoirement sur le plateau (case finale tout le temps de type Trésor)
     */
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