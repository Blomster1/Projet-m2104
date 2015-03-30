/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.m2104;

/**
 *
 * @author yevic
 */
public abstract class Personne {
    private String nomPersonne;
    private String prenomPersonne;
    
    public Personne(String nomPersonne, String prenomPersonne){
        this.nomPersonne=nomPersonne;
        this.prenomPersonne=prenomPersonne;
    }
    
    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }
    
    
}
