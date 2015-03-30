/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.m2104;

import java.util.Scanner;

/**
 *
 * @author yevic
 */
public class FFCAM {
   
    public FFCAM(){}

    public void nouveauCAF(){
    // Creer un nouveau CAF
        String nom;
        String adresse;
        String site;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisissez le nom du CAF");
        nom = sc.nextLine();
        
        System.out.print("\n Saisissez l'adresse du CAF");
        adresse = sc.nextLine();
        System.out.print("\n Saisissez le site du CAF");
        site = sc.nextLine();
        
        new CAF(nom,adresse,site);
    }
    
    public void nouvelleActivite(){
    //Creer un nouvelle activité
        String nomAct;
        
         Scanner sc = new Scanner(System.in);
         System.out.print("Nom de l'activité : ");
         nomAct = sc.nextLine();
         
        new Activite(nomAct);
    }
    
    public void ajouterActiviteCAF(){
        
    }
}
