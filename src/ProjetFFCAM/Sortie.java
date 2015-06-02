/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author hanriaca
 */


class Sortie implements Serializable{
//    private HashSet<Adherent> lesParticipants;
//    private HashSet<Inscription> inscriptions;
    private HashMap<Adherent,Inscription> inscriptions;
    private HashSet<Moniteur> lesMoniteurs;
    
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
//        lesParticipants = new HashSet<>();
        lesMoniteurs = new HashSet<>();
        inscriptions = new HashMap<>();
    }
    
    //GETTERS

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

//    public HashSet<Inscription> getInscriptions() {
//        return inscriptions;
//    }
//    public Inscription getInscription(Adherent a) {
//        return this.getInscriptions()
//    }
    public HashMap<Adherent, Inscription> getInscriptions() {
        return inscriptions;
    }
    
    public Inscription getInscription(Adherent a) {
        return this.getInscriptions().get(a);
    }
    
    
    
    //SETTERS

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

//    public void setInscriptions(HashSet<Inscription> inscriptions) {
//        this.inscriptions = inscriptions;
//    }
    public void setInscriptions(HashMap<Adherent, Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    
    
    
    
    // AJOUT DES PARTICPANTS
//    private void addPariticpants(Adherent a){
//        lesParticipants.add(a);
//    } 
    public void ajouterInscription(Inscription i, Adherent a){
        //ajoute un participant à l'inscription
        //si il existe
//        if(!getLesParticipants().contains(a)){
//            this.addPariticpants(a);
//            System.out.println("Participant ajouté OK");
//            return true;
//        } else {
//            System.out.println("Ce participant participe deja a cette activité.");
//            return false;
//        }
        
        //si l'inscription existe
        this.getInscriptions().put(a, i);
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
            System.out.println("ERREUR : Le moniteur n'existe pas");
            return false;
        }
    }   
}