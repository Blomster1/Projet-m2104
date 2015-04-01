/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetFFCAM;

import java.util.HashSet;
/**
 *
 * @author blomster
 */
public class Adherent extends Personne {

    private String adresse;
    private double soleNuites = 0;
    HashSet<Sortie> lesSorties;
    
    public Adherent(String n, String p, String a, double solde) {
        super(n, p);
        this.setAdresse(a);
        this.setSoleNuites(solde);
        lesSorties = new HashSet<>();
    }

    //GETTERS
    public String getAdresse() {
        return adresse;
    }
    public double getSoleNuites() {
        return soleNuites;
    }
    
    //SETTERS
    private void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    private void setSoleNuites(double soleNuites) {
        this.soleNuites = soleNuites;
    }
    
    //AJOUT DE SORTIES
    @Override
    public void ajouterSortie(Sortie s){
        if(!lesSorties.contains(s)){
            this.addSortie(s);
        } else {
            System.out.println("ERREUR : la sortie existe déjà. ");
            }
        }
    

}
