/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.m2104;

// Importation de l'utilitaire date
import java.util.GregorianCalendar;

/**
 *
 * @author yevic
 */
public class Sortie {
    private String nomSortie;
    private GregorianCalendar date;
    private double prixNuite;

    public Sortie(String nomSortie, GregorianCalendar date, double prixNuite) {
        this.nomSortie = nomSortie;
        this.date = date;
        this.prixNuite = prixNuite;
    }

    public String getNomSortie() {
        return nomSortie;
    }

    public void setNomSortie(String nomSortie) {
        this.nomSortie = nomSortie;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public double getPrixNuite() {
        return prixNuite;
    }

    public void setPrixNuite(double prixNuite) {
        this.prixNuite = prixNuite;
    }
    
    
}
