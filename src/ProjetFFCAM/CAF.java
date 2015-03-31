package ProjetFFCAM;




import java.io.*; import java.util.*;
import java.io.Serializable;

public class CAF implements java.io.Serializable {
	
	private String nomCAF;
	private String adresse;
	private String site;

	//Constructeur
	public CAF(String n, String a, String s) {
		this.setNomCAF(n);
		this.setAdresse(a);
		this.setSite(s);
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
	

}
