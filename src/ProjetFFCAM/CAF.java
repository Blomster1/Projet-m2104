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

        public HashSet<Activite> getActivitesDuClub() {
            return ActivitesDuClub;
        }

        public void setActivitesDuClub(HashSet<Activite> ActiviteDuClub) {
            this.ActivitesDuClub = ActiviteDuClub;
        }
	
        

}
