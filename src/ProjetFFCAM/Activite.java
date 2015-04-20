/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

import java.io.Serializable;
import java.util.HashSet;
/**
 *
 * @author tabitay
 */
public class Activite implements Serializable {
    private String nomAct;
    HashSet<CAF> lesClubs;
    HashSet <Sortie> sorties;
    
    public Activite(String nomAct) {
        setNomAct(nomAct);
        lesClubs = new HashSet<>();
        sorties = new HashSet<>();
    }

    //GETTERS
    public HashSet<Sortie> getSorties() {
        return sorties;
    }
    public String getNomAct() {
        return nomAct;
    }
    public HashSet<CAF> getLesClubs() {
        return lesClubs;
    }
    
    
    
    //SETTERS
    private void setNomAct(String n) {
        this.nomAct = n;
    }
    private void setSorties(HashSet<Sortie> sorties) {
        this.sorties = sorties;
    }
    
    private void setLesClubs(HashSet<CAF> lesClubs) {
        this.lesClubs = lesClubs;
    }
    

    //AUTRES
    private void addClub(CAF cl){
        this.getLesClubs().add(cl);
    }


    public boolean ajouterClub(CAF cl){
        
        if(!this.getLesClubs().contains(cl)){
            addClub(cl);
            return true;
        } else {
            System.out.println("Le club n'existe pas");
            return false;
        }
    }
}