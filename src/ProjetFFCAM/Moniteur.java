/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetFFCAM;

/**
 *
 * @author loft-2014
 */
public class Moniteur extends Personne {
    //déclarations
    
    private String diplome;
    private int numero;
    
    //constructeur
    public Moniteur (String n, String p, String d, int num) {
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
