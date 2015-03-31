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
public class Activite {
    private String nomAct;

    public Activite(String nomAct) {
        setNomAct(nomAct);
    }

    public String getNomAct() {
        return nomAct;
    }

    private void setNomAct(String n) {
        this.nomAct = n;
    }
    
    
}
