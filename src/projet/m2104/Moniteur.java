/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.m2104;

/**
 *
 * @author yevic
 */
public class Moniteur extends Personne {
    private int numMoniteur;
    private String diplome;

    public Moniteur(int numMoniteur, String diplome, String nomPersonne, String prenomPersonne) {
        super(nomPersonne, prenomPersonne);
        this.numMoniteur = numMoniteur;
        this.diplome = diplome;
    }

    public int getNumMoniteur() {
        return numMoniteur;
    }

    public void setNumMoniteur(int numMoniteur) {
        this.numMoniteur = numMoniteur;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    
}
