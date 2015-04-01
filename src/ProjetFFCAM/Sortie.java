/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

import java.util.*;
/**
 *
 * @author hanriaca
 */
class Sortie {
    HashSet<Personne> lesParticipants;
    private String nomSortie;
    private double prixNuite;
    private GregorianCalendar date;
    private Activite type;
    private CAF Organisateur;
    
    
    public Sortie(String n, GregorianCalendar d, Activite a, double p, CAF c){
        this.setNomSortie(n);
        this.setPrixNuite(p);
        this.setDate(d);
        this.setType(a);
        this.setOrganisateur(c);
        lesParticipants = new HashSet<>();
    }
    
    //GETTERS

    public HashSet<Personne> getLesParticipants() {
        return lesParticipants;
    }
    public String getNomSortie() {
        return nomSortie;
    }
    public double getPrixNuite() {
        return prixNuite;
    }
    public GregorianCalendar getDate() {
        return date;
    }
    public Activite getType() {
        return type;
    }
    public CAF getOrganisateur() {
        return Organisateur;
    }
    
    
    
    //SETTERS

    private void setLesParticipants(HashSet<Personne> lesPersonnes) {
        this.lesParticipants = lesPersonnes;
    }
    private void setNomSortie(String nomSortie) {
        this.nomSortie = nomSortie;
    }
    private void setPrixNuite(double prixNuite) {
        this.prixNuite = prixNuite;
    }
    private void setDate(GregorianCalendar date) {
        this.date = date;
    }
    private void setType(Activite type) {
    this.type = type;
    }
    private void setOrganisateur(CAF Organisateur) {
        this.Organisateur = Organisateur;
    }
    
    // AJOUT DES PARTICPANTS
 /*   private void addPariticpants(Personne p){
        lesParticipants.add(p);
    }
    
    public boolean ajouterParticipants(){
    }
        */

 


    
}

