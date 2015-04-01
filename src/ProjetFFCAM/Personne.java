/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

import java.util.HashSet;
/**
 *
 * @author hanriaca
 */
public abstract class Personne {
    private String prenom;
    private String nom;
    private HashSet<Sortie> sorties;
    
    //constructeur
    public Personne (String n, String p) {
        this.setPrenomPersonne(p);
        this.setNomPersonne(n);
        sorties = new HashSet();
    }
    
    
    //ensemble des setters : 
    //--------------------------
    private void setNomPersonne(String n) {
        nom = n;        
    }
    private void setPrenomPersonne(String p) {
        prenom = p;
    }
    private void setSorties(HashSet<Sortie> s) {
        sorties = s;
    }
    

    
    
    
    //----------------------------------------ensemble des getteurs :
    //---------------------------------------------------------------
    public HashSet getSorties() {
        return sorties;
    }
    public String getNomPersonne() {
        return nom;
    }  
    public String getPrenomPersonne() {
        return prenom;
    }    
    
    
    //Autre :
    //---------
    public void ajouterSortie (Sortie s) {
        if (!this.getSorties().contains(s)) {
            this.addSortie(s);
        }
        else {
            System.out.println("ERREUR : la sortie existe déjà. ");
        }
    }
    
    public void addSortie(Sortie s) {
    //SPECIFICATION : la sortie s n'existe pas dans la base de donnée
        //Mais non mec on s'en branle on le verifie au dessus ca
        sorties.add(s);
    }
}
