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
public class Adherent extends Personne {
    private int numAdherent;
    private String adresse;
    private double soldeNuites = 0;
    
    public Adherent(int numAdherent, String adresse, String nomPersonne, String prenomPersonne) {
        super(nomPersonne, prenomPersonne);
        this.numAdherent = numAdherent;
        this.adresse = adresse;
    }

    public int getNumAdherent() {
        return numAdherent;
    }

    public void setNumAdherent(int numAdherent) {
        this.numAdherent = numAdherent;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSoldeNuites() {
        return soldeNuites;
    }

    public void setSoldeNuites(double soldeNuites) {
        this.soldeNuites = soldeNuites;
    }
    
    
}

