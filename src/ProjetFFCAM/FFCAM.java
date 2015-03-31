package ProjetFFCAM;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class FFCAM {
         // Fichier de sérialisation
	private static final String DB_FILE = "clubs.db";
	// les clubs locaux identifiés par leur nom
	private HashMap<String, CAF> lesClubs;
        //Les activités sont identifié par leur nom
        private HashMap<String, Activite> lesActivites;
	
  
    /**
     * Initialise le fichier de sérialisation
     */
public FFCAM() {
    }

private HashMap<String, CAF> getClubs() {
	return lesClubs;
}

private HashMap<String, Activite> getActivites(){
    return lesActivites;
}
    /**
     * retourne le club à partir de son nom
     */
private CAF getClub(String nom){
	return getClubs().get(nom);
}
    /**
     * ajoute le club avec son nom dans le tableau associatif
     */
private void addClub(CAF c, String n){
	this.getClubs().put(n, c);
}

private void setClubs(HashMap<String, CAF> clubs){
	lesClubs = clubs;
}
    /**
     * création d'un nouveau club local
     */
public void nouveauCAF()	{
	Scanner sc = new Scanner(System.in);
	System.out.println("\nAjout d'un CAF local\n");			
	System.out.print("Nom du CAF :\t");
	String nomc = 	sc.nextLine();
	
        
        if (this.getClub(nomc) == null) {
            //Si on ne trouve pas de club ayant le nom saisi
		System.out.print("Adresse du CAF :\t");
		String a = 	sc.nextLine();
		System.out.print("Site internet du CAF :\t");
		String s = sc.nextLine();
			
		CAF caf = new CAF (nomc, a, s);
		this.addClub(caf, nomc);
		System.out.println("\n\tCreation du CAF local OK\n"); 
	}
	else {
                System.out.println("\n\tUn CAF local de même nom existe déjà\n");
                        
	}
}

private void addActivite(Activite a, String s){
    //ajoute une activité dans le tableau associatif
    this.getActivites().put(s,a);
}
private void setActivites(HashMap<String,Activite> activites){
    //Initialise un tableau d'activité
    lesActivites=activites;
}

private Activite getActivite(String nomA) {
    //Retourne une activité a partir de son nom
        return getActivites().get(nomA);
    }

public void nouvelleActivite(){
        ;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAjout d'une activite\n");
        System.out.print("Nom de l'activité :\t");
        String nomA = sc.nextLine();
        sc.close();
        
        if(this.getActivite(nomA)==null){
            Activite act= new Activite(nomA);
            this.addActivite(act,nomA);
        } else {
            System.out.println("\nUne activite de même nom existe déjà\n");
        }
        
}

    /**
     * Met à jour du fichier de sérialisation
     */
    public boolean updateDB() {
        return saveDB();
    }

    /**
     * Création d'une nouvelle sérialisation
     */
    public void newDB() {
	//this.setNumDerMonit(0);
	this.setClubs(new HashMap<String, CAF>());
	this.setActivites(new HashMap<String, Activite>());
	//this.setMoniteurs(new HashMap<Integer, Moniteur>()); 
    }
    
   /**
    * Sauvegarde du fichier de sérialisation
    */
	
    private boolean saveDB() {
        File file;
        boolean success = true;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;            
        
        file = new File(DB_FILE);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            //oos.writeInt(numDerMonit);
            oos.writeObject(lesClubs);
            oos.writeObject(lesActivites);
            //oos.writeObject(lesMoniteurs);
            
        }
        catch (Exception e) {
            System.out.println("SAVE" + e);
            success = false;
        }
        finally {
                if (oos != null) { 
                    try { oos.close(); }
                    catch(IOException e) {}
                }
                
                if (fos != null) { 
                    try { fos.close(); }
                    catch(IOException e) {}
                }
            
        }
        return success;
    }
    
    /**
     * Chargement des données à partir d'un fichier de sérialisation
     */
    public boolean loadDB() {
        boolean success = true;
        File file = new File(DB_FILE);
        
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;            

            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
               // numDerMonit = ois.readInt();
                lesClubs = (HashMap<String, CAF>) ois.readObject();
                lesActivites = (HashMap<String, Activite>) ois.readObject();
                //lesMoniteurs = (HashMap<Integer, Moniteur>) ois.readObject();
            }             
            catch(Exception e) {
                System.out.println("LOAD" + e);
                success = false;
            }
            finally {
                if (ois != null) { 
                    try { ois.close(); }
                    catch(IOException e) {}
                }
                
                if (fis != null) { 
                    try { fis.close(); }
                    catch(IOException e) {}
                }
            }
        } else { success = false; }
        return success;
    }

    

}





