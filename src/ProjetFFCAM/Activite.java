/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

import java.util.HashSet;

/**
 *
 * @author tabitay
 */
public class Activite {
    private String nomAct;
    HashSet<CAF> lesClubs;

    public Activite(String nomAct) {
        setNomAct(nomAct);
        lesClubs = new HashSet<>();
    }

    public String getNomAct() {
        return nomAct;
    }

    private void setNomAct(String n) {
        this.nomAct = n;
    }

    public HashSet<CAF> getLesClubs() {
        return lesClubs;
    }
    

    public void setLesClubs(HashSet<CAF> lesClubs) {
        this.lesClubs = lesClubs;
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
    
    private void addClub(CAF cl){
        this.getLesClubs().add(cl);
    }
    
}
