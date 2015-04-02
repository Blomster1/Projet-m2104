/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetFFCAM;

import java.io.Serializable;

/**
 *
 * @author loft-2014
 */
public class Moniteur extends Personne implements Serializable {
    //déclarations
    
    private String diplome;
    private int numero;
    
    //constructeur
    public Moniteur (String n, String p,int num,String d) {
        super(n,p);
        this.setDiplome(d);
        this.setNumero(num);
    }
    
    
    //getteurs
    public String getDiplome () {
        return diplome;
    }
    public int getNumero() {
        return numero;
    }
    
    //setteurs
    private void setDiplome (String d) {
        diplome = d;
    }
    private void setNumero (int n) {
        numero = n;
    }
}
