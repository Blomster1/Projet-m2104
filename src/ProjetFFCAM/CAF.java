package ProjetFFCAM;




import java.io.*; import java.util.*;
import java.io.Serializable;

public class CAF implements java.io.Serializable {
	
	private String nomCAF;
	private String adresse;
	private String site;
        private HashSet<Activite> ActivitesDuClub;
        

	//Constructeur
	public CAF(String n, String a, String s) {
		this.setNomCAF(n);
		this.setAdresse(a);
		this.setSite(s);
                ActivitesDuClub = new HashSet<>();
	}

	private void setSite(String s) {
		site = s;		
	}
        
	private void setNomCAF(String n){
		nomCAF = n;
	}
 
	private void setAdresse(String a){
		adresse = a ;
	}
        
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
            return ActivitesDuClub;
        }

        private void setActivites(HashSet<Activite> ActiviteDuClub) {
            this.ActivitesDuClub = ActiviteDuClub;
        }
	
        public boolean ajouterActivite(Activite a){
            if(!this.getActivites().contains(a)){
                addActivite(a);
                a.ajouterClub(this);
                return true;
            } else {
                System.out.println("Cette activité n'existe pas.");
                return false;
            }
        }

    private void addActivite(Activite a) {
        this.getActivites().add(a);
    }
        
        
        
}
