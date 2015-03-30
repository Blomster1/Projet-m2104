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
public class CAF {
    private String nomCAF;
    private String adresse;
    private String site;

    public CAF(String nomCAF, String adresse, String site) {
        setNomCAF(nomCAF);
        setAdresse(adresse);
        setSite(site);
    }

    public String getNomCAF() {
        return nomCAF;
    }

    private void setNomCAF(String nomCAF) {
        this.nomCAF = nomCAF;
    }

    public String getAdresse() {
        return adresse;
    }

    private void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSite() {
        return site;
    }

    private void setSite(String site) {
        this.site = site;
    }
    
    
}
