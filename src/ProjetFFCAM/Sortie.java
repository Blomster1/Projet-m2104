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
class Sortie{
    HashSet<Adherent> lesParticipants;
    HashSet<Moniteur> lesMoniteurs;
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
        lesMoniteurs = new HashSet<>();
    }
    
    //GETTERS
    public HashSet<Adherent> getLesParticipants() {
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
    public HashSet<Moniteur> getLesMoniteurs() {
        return lesMoniteurs;
    }
    
    
    
    //SETTERS
    private void setLesParticipants(HashSet<Adherent> lesPersonnes) {
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
    private void setLesMoniteurs(HashSet<Moniteur> lesMoniteurs) {
        this.lesMoniteurs = lesMoniteurs;
    }
    
    
    // AJOUT DES PARTICPANTS
    private void addPariticpants(Adherent a){
        lesParticipants.add(a);
    } 
    public boolean ajouterParticipants(Adherent a){
        if(!getLesParticipants().contains(a)){
            this.addPariticpants(a);
            System.out.println("Participant ajouté OK");
            return true;
        } else {
            System.out.println("Ce participant participe deja a cette activité.");
            return false;
        }
    }
    
// AJOUT DES ENCADRANTS
    private void addEncadrant(Moniteur m){
        lesMoniteurs.add(m);
    }
    public boolean ajouterEncadrant(Moniteur m){
        if(!lesMoniteurs.contains(m)){
            this.addEncadrant(m);
            return true;
        } else {
            return false;
        }
}
 

 


    
}

