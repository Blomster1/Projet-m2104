/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetFFCAM;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Adherent extends Personne implements Serializable {

    private String adresse;
    private double soleNuites = 0;
    HashSet<Sortie> lesSorties;
//    HashSet<Inscription> lesInscriptions;
    HashMap<Sortie,Inscription> inscriptions;

    private String numAdherent;
    
    public Adherent(String num, String n, String p, String a) {
        super(n, p);
        this.setAdresse(a);
        this.setNumAdherent(num);
        //this.setSoleNuites(solde);
        lesSorties = new HashSet<>();
//        lesInscriptions = new HashSet<>();
        inscriptions = new HashMap<>();
    }


    //GETTERS
    public String getNumAdherent() {
        return numAdherent;
    }
    public String getAdresse() {
        return adresse;
    }
    public double getSoleNuites() {
        return soleNuites;
    }

    public HashMap<Sortie,Inscription> getInscriptions() {
//        return lesInscriptions;
        return inscriptions;
    }
    
    public Inscription getInscription (Sortie s) {
        return this.getInscriptions().get(s);
        
//        for (Inscription i : this.getLesInscriptions()) {
//            if (i.getSortie().equals(s)){
//                return i;
//            }
////        }
//        return null;
    }
    
    
    //SETTERS
    
    private void setNumAdherent(String numAdherent) {
        this.numAdherent = numAdherent;
    }

    private void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    private void setSoleNuites(double soleNuites) {
        this.soleNuites = soleNuites;
    }
    
    //AJOUT DE SORTIES
    @Override
    public void ajouterSortie(Sortie s){
        this.setSoleNuites(this.getSoleNuites()+1);
        if(!lesSorties.contains(s)){
            this.addSortie(s);
        } else {
            System.out.println("ERREUR : la sortie existe déjà. ");
            }
        }

    public void ajouterInscription(Inscription i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de personnes vous accompagne ?");
                int accompagnants = sc.nextInt();
        i.setAccompagnant(accompagnants);
        this.setSoleNuites(this.getSoleNuites() + i.getSortie().getPrixNuite());
        this.getInscriptions().put(i.getSortie(), i);
    }
    

}
