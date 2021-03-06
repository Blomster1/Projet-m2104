package ProjetFFCAM;




import java.io.*; import java.util.*;
import java.io.Serializable;

public class CAF implements Serializable {
	
    private String nomCAF;
    private String adresse;
    private String site;
    private HashSet<Activite> activitesDuClub;
    private HashMap<String, Sortie> sorties;
    private HashMap<String, Adherent> adherents ;

    //Constructeur
    public CAF(String n, String a, String s) {
            this.setNomCAF(n);
            this.setAdresse(a);
            this.setSite(s);
            adherents = new HashMap<>();
            activitesDuClub = new HashSet<>();
            sorties = new HashMap<>();
    }

    //GETTERS
    public String getSite() {
            return site;		
    }
    public String getNomCAF(){
            return nomCAF ;
    }
    public String getAdresse(){
            return adresse;
    }
    public HashSet<Activite> getActivites() {
        return activitesDuClub;
    }
    private HashMap<String, Sortie> getSorties() {
        return sorties;
    }
    public HashMap<String, Adherent> getAdherents() {
        return this.adherents;
    }
    public Sortie getSortie(String nomS){
        //Retourne une sortie en fonction de son nom
        return getSorties().get(nomS);
    }
    public Adherent getAdherent(String num){
        //Retourne un adherent en fonction de son num
        return getAdherents().get(num);
    }
        
    //SETTERS
    private void setSite(String s) {
            site = s;		
    }
    private void setNomCAF(String n){
            nomCAF = n;
    }
    private void setAdresse(String a){
            adresse = a ;
    }
    private void setActivites(HashSet<Activite> ActiviteDuClub) {
        this.activitesDuClub = ActiviteDuClub;
    }

    private void setSorties(HashMap<String, Sortie> sorties) {
        this.sorties = sorties;
    }
    public void setAdherents(HashMap<String, Adherent> adherents) {
        this.adherents = adherents;
    }
    
    
    //AJOUTER ACTIVITE
    public boolean ajouterActivite(Activite a){
        if(!this.getActivites().contains(a)){
            addActivite(a);
            a.ajouterClub(this);
            return true;
        } else {
            System.out.println("Cette Acivite existe deja pour ce CAF local.");
            return false;
        }
    }

    private void addActivite(Activite a) {
        this.getActivites().add(a);
    }

   //AJOUTER ADHERENT
   private void addAdherent(String numa, Adherent a){
       adherents.put(numa, a);
   }
   
   //AJOUTER SORTIE
   public void ajouterSortie(String n, GregorianCalendar d, Activite a, double p) {
        //ajoute la sortie.
       Sortie sort = new Sortie(n,d,a,p,this);
       
       //si la sortie existe pas, on l'ajoute
       if (this.getSortie(n) == null) {
           this.addSortie(n, sort);
       }
       else {
           System.out.println("ERREUR : La sortie existe deja dans le club " + this.getNomCAF());
       }
   }
   private void addSortie(String noms, Sortie s){
       sorties.put(noms, s);
   }

    public void ajouterAdherent(String num, String nom, String prenom, String adresse) {
        //le numero d'adherent est composé des 3 premieres lettres du nom du club + le nom + un numéro généré aléatoirment.
            //on va utiliser subString pour récupérer les 3 premières lettres du nom du CAF.
        //Random r = new Random();
        //on vérifie que l'adhérent n'existe pas.
        if (this.getAdherent(nom) != null) { 
            System.out.println("ERREUR : L'adherent existe déjà.");            
        }
        else {            
            this.addAdherent(num, new Adherent(num, nom, prenom, adresse));
        }
    }
}
