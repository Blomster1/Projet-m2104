/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetFFCAM;

/**
 *
 * @author tabitay
 */
import java.io.Serializable;
import java.util.GregorianCalendar;
    

public class Inscription implements Serializable{
   
    private GregorianCalendar date;
    private int accompagnant;
    private Sortie sortie;
    private Adherent adherent;
    
    
    public Inscription(GregorianCalendar date, Sortie s){
        this.setDate(date);
        this.setSortie(s);
    }
    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    


    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public int getAccompagnants() {
        return accompagnant;
    }

    public void setAccompagnant(int accompagnant) {
        this.accompagnant = accompagnant;
    }

    public Sortie getSortie() {
        return sortie;
    }

    private void setSortie(Sortie s) {
        this.sortie = s;
    }
    
    
}
