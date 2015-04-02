package ProjetFFCAM;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

public class FFCAM implements Serializable{
         // Fichier de sérialisation
	private static final String DB_FILE = "clubs.db";
	// les clubs locaux identifiés par leur nom
	private HashMap<String, CAF> lesClubs;
        //Les activités sont identifié par leur nom
        private HashMap<String, Activite> lesActivites;
        //Les moniteurs sont identifiés par leurs numéros
        private HashMap<Integer, Moniteur> moniteurs;
        //dernier numero de moniteur
        private int numDerMonit;
    /**
     * Initialise le fichier de sérialisation
     */
public FFCAM() {
    lesActivites = new HashMap<>();
    lesClubs = new HashMap<>();
    moniteurs = new HashMap<>();
    numDerMonit=0;
    }

private HashMap<String, CAF> getClubs() {
	return lesClubs;
}
/*
    Activite ---------------------------------------
*/

private HashMap<String, Activite> getActivites(){
    return lesActivites;
}
//Retourne le hashmap dontenant les activités

private void setActivites(HashMap<String,Activite> activites){
   
    lesActivites=activites;
}
 //Initialise un tableau d'activité

private Activite getActivite(String nomA) {
    
        return getActivites().get(nomA);
}
//Retourne une activité a partir de son nom

public void ajouterActivite(){
    CAF caf;
    Scanner sc = new Scanner(System.in);
    String nomClub;
    String nomAct;
    System.out.println("Nom du club : ");
    nomClub = sc.nextLine();
     if(lesClubs.get(nomClub)!=null){
        caf = lesClubs.get(nomClub); 
        System.out.println("Nom de l'activité : ");
        nomAct = sc.nextLine();
        if(getActivite(nomAct)!=null){
        caf.ajouterActivite(getActivite(nomAct));
        } else {
            System.out.println("Cette activité n'existe pas.");
        }
     } else {
         System.out.println("Le club n'existe pas.");
     }
}
//Ajoute une activité pour un club donné

public void afficheInfosAct(){
    String nomAct;
    Activite act;
    Scanner sc = new Scanner(System.in);
    System.out.println("Nom de l'activite : ");
    nomAct = sc.nextLine();
    
    if(getActivite(nomAct)!=null){        
  //      CAF LC = getActivite(nomAct).getLesClubs();
        System.out.println("nom activite : " + getActivite(nomAct).getNomAct());
        for (CAF lc : getActivite(nomAct).getLesClubs() ) {
            System.out.println("Nom Caf : "+lc.getNomCAF());
            System.out.println("     Adresse : "+lc.getAdresse());
            System.out.println("     Site : "+lc.getSite());
            System.out.println("---------------------");
        }
    }
}
//Affiche toute les infos d'une activité

//---------------------------------------------

/*
    CLUBS --------------------------------------
*/
private CAF getClub(String nom){
	return getClubs().get(nom);
}
//retourne le club à partir de son nom

private void addClub(CAF c, String n){
    
	this.getClubs().put(n, c);
}
//ajoute le club avec son nom dans le tableau associatif

private void setClubs(HashMap<String, CAF> clubs){
	lesClubs = clubs;
}
//Initialise un tableau contenant les clubs

public void nouveauCAF(){
    
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
//création d'un nouveau club local

private void addActivite(Activite a, String s){
    
    lesActivites.put(s, a);
}
//ajoute une activité dans le tableau associatif

//---------------------------travail sur moniteur

private void addMoniteur(Moniteur m, Integer num) {
//ajoute dans le hashmap le moniteur 
    moniteurs.put(num, m);
    this.genereNumMonit();
}

public void nouveauMoniteur() {
//ajoute un nouveau moniteur au hashmap moniteurs suite à une demande.
    Scanner sc = new Scanner(System.in);
    String nom;
    String prenom;
    String diplome;
    
    System.out.println("\tAjout d'un moniteur : ");
    System.out.print("Nom : ");
    nom = sc.nextLine();
    System.out.print("Prenom : ");
    prenom = sc.nextLine();
    System.out.print("Diplome : ");
    diplome = sc.nextLine();
    
    Moniteur monit = new Moniteur(nom,prenom,this.getNumDerMonit(),diplome);
    System.out.println("Nouveau moniteur au numéro : " + monit.getNumero());

    this.addMoniteur(monit, monit.getNumero());
}
public void ajouterEncadrant() {
//ajoute l'encadrant sur une sortie
}
private HashMap<Integer,Moniteur> getMoniteurs() {
    return moniteurs;
}

private Moniteur getMoniteur(Integer num) {
    return this.getMoniteurs().get(num);
}

private int genereNumMonit() {
    //incrémente de 1
    this.setNumDerMonit(this.getNumDerMonit()+1);
    return this.getNumDerMonit();
}


public int getNumDerMonit() {
//procedure qui conserve le dernier numéro de moniteurs
    return numDerMonit;
}

private void setNumDerMonit(int i) {
    //pour l'incrémentation
    numDerMonit = i;
}

private void setMoniteurs (HashMap<Integer,Moniteur> monits) {
    moniteurs = monits;
}
//----------------Activitees
public void nouvelleActivite(){
        String nomA;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAjout d'une activite\n");
        System.out.print("Nom de l'activité :\t");
        nomA = sc.nextLine();
        
        
        //
        //si l'activitée est pas existente
        
        if (this.getActivite(nomA)==null) {
            Activite act = new Activite(nomA);
            this.addActivite(act, nomA);
        }
        else 
        {
            System.out.println("\nUne activite de même nom existe déjà\n");
        }


}

//--------clubs
public void nouvelleSortieClub() {
//la procédure doit créer une sortie pour un club CAF.
    Scanner sc = new Scanner (System.in);
    String nomClub;
    String nomso;
    String nomact;
    Sortie sort;
//    int annee;
//    int mois;
//    int jour;
    GregorianCalendar da = new GregorianCalendar();
    double pn;
    
    System.out.println("Entrez le nom du club dans lequel vous voulez insérer l'activitee : ");
    nomClub = sc.nextLine();
    
    if (this.getClub(nomClub) != null) {
    //Verification de l'existance du club
        System.out.println("Nom de l'activité de la sortie : ");
        nomact = sc.nextLine();
        if(this.getClub(nomClub).getActivites().contains(this.getActivite(nomact))){
           //je recupere le club.je recupere son tableau d'activité.je verifi qu'il contient l'activité saisie 
        //Verification de l'existance de l'activité
            System.out.println("\nCréation d'une nouvelle sortie pour le club " + nomClub);
            System.out.println("Nom de la sortie : ");
            nomso = sc.nextLine();
            System.out.println("prix de nuité : ");
            pn = sc.nextInt();
            System.out.println("date de la sortie :  ");  
            //pour le moment je vais en créer une en dure.
            da = new GregorianCalendar(2015,2,15);
            //Je teste d'en faire une en dynamique gros

            //appel du constructeur :
            sort = new Sortie(nomso, da,this.getActivite(nomact), pn, this.getClub(nomClub));
            //ajouter la sortie au club
            this.getClub(nomClub).ajouterSortie(nomso, da, this.getActivite(nomact), pn, this.getClub(nomClub));
        } else {
            System.out.println("ERREUR : l'activité n'existe pas.");
        }
    } 
    //sinon on met un message d'erreur.
    else {
        System.out.println("ERREUR : Le club de ce nom n'existe pas!");
    }
    
}

public void afficheInfos(){ 
    CAF caf;
    String nomClub;
    Scanner sc = new Scanner(System.in);
    System.out.println("Nom du club : ");
    nomClub=sc.nextLine();
    if(lesClubs.get(nomClub)!=null){
        caf = lesClubs.get(nomClub);
        System.out.println(caf.getNomCAF());
        System.out.println(caf.getAdresse());
        System.out.println(caf.getSite());
        System.out.println("Liste des activités proposées par le club :");
        for(Activite act : caf.getActivites()){
            System.out.println("    - " + act.getNomAct());
        }        
    } else {
        System.out.println("Ce club n'existe pas.");
    }
}
//Affiche les information d'une activité

//---------------------------------------------


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
	this.setNumDerMonit(0);
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

            oos.writeInt(numDerMonit);
            oos.writeObject(lesClubs);
            oos.writeObject(lesActivites);
           //oos.writeObject(moniteurs);
            
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
                numDerMonit = ois.readInt();
                lesClubs = (HashMap<String, CAF>) ois.readObject();
                lesActivites = (HashMap<String, Activite>) ois.readObject();
                //moniteurs = (HashMap<Integer, Moniteur>) ois.readObject();
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





