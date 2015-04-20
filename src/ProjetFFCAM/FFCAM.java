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
    int annee;
    int mois;
    int jour;
    GregorianCalendar da;
    double pn;
    CAF c;
    Activite act;
    
    System.out.println("Entrez le nom du club dans lequel vous voulez insérer l'activitee : ");
    nomClub = sc.nextLine();
    //si le club existe, on fait saisir le nom de l'activitée. 
    if (this.getClub(nomClub) != null) {
        c = this.getClub(nomClub);
        System.out.println("Nom de l'activité de la sortie : ");
        nomact = sc.nextLine();
        //si l'activitée existe dans le hashmap de ffcam
        if(this.getActivite(nomact) != null){
            act = this.getActivite(nomact);
            System.out.println("\nCréation d'une nouvelle sortie pour le club " + nomClub);
            System.out.println("Nom de la sortie : ");
            nomso = sc.nextLine();
            
            //la sortie = une sortie du hashmap "sorties" de club
            sort = c.getSortie(nomso);

            //si la sortie n'est pas prévue alors saisir la date et le prix.
            if (sort.getDate()==null) {
                System.out.println("prix de nuité : ");
                pn = sc.nextInt();
                System.out.println("date de la sortie :  ");
                System.out.print("Jour : ");
                jour = sc.nextInt();
                System.out.print("Mois : ");
                mois = sc.nextInt();
                System.out.print("Annee : ");
                annee = sc.nextInt();
                da = new GregorianCalendar(annee, mois, jour);
                c.ajouterSortie(nomso,da,act,pn);
                
            }            
        }
        else {
            System.out.println("ERREUR : L'activitee n'existe pas");
        }
    }
    //sinon on met un message d'erreur.
    else {
        System.out.println("ERREUR : Le club de ce nom n'existe pas!");
    }
    
}

public void inscrireAdherentSortie() {
    //inscrit un adhérent dans une activitée d'un CAF
    String nomC;
    String nomS;
    String nomA;
    Scanner sc = new Scanner(System.in);
    //demande le nom d'un club dans lequel nous voulons ajouter l'adherent.
    System.out.print("Entrez le nom de l'activitée ou vous voulez inscrire l'adherent : ");
    nomC = sc.nextLine();
    //vérification de l'existence d'un club.
    if(this.getClub(nomC)!=null) {
        //demande le nom d'une sortie
        System.out.print("Entrez le nom de la sortie : ");
        nomS = sc.nextLine();
        //verification de l'existence d'une sortie : 
        if(this.getClub(nomC).getSortie(nomS) != null) {
            //demande du nom de l'Adherent
            System.out.print("Entrez le nom de l'Adherent : ");
            nomA = sc.nextLine();
            //verifie si l'adherent existe, et si il n'est pas deja inscrit à une activitee à la même date
            if((this.getClub(nomC).getAdherent(nomA) != null)) {
                //appel de ajouterParticipant pour la sortie de nom nomS
                this.getClub(nomC).getSortie(nomS).ajouterParticipants(this.getClub(nomC).getAdherent(nomA));
            }
            else {
                System.out.println("ERREUR : la sortie n'existe pas.");
            }
            
        }
        else {
            System.out.println("ERREUR : La sortie existe pas.");
        }
    }
    else {
        System.out.println("ERREUR : l'activité demandée n'existe pas.");
    }
}

public void nouvelAdherent() {
    //ajoute un adherent dans un CAF , c'est à dire, dans le HashMap du CAF.
    
    String nomClub;
    Scanner sc = new Scanner(System.in);
    String num, nom, prenom, adresse;
    num = "";
    
    System.out.print("Veuillez entrer le nom du club dans lequel vous voulez ajouter un adhérent : ");
    nomClub = sc.nextLine();
    
    //si le club n'existe pas
    if (this.getClub(nomClub) == null) {
        System.out.println("ERREUR : Le club demandé n'existe pas. ");
    }
    else {
        System.out.print("Entrez le nom de l'adherent : ");
        nom = sc.nextLine();
        System.out.print("Entrez le prenom de l'adherent : ");
        prenom = sc.nextLine();
        System.out.print("Entrez l'adresse de l'adherent : ");
        adresse = sc.nextLine();
        this.getClub(nomClub).ajouterAdherent(num, nom, prenom, adresse);
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
        System.out.print("Nom du club : ");
        System.out.println(caf.getNomCAF());
        System.out.print("Adresse : ");
        System.out.println(caf.getAdresse());
        System.out.print("Site internet : ");
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
	this.setMoniteurs(new HashMap<Integer, Moniteur>()); 
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
           oos.writeObject(moniteurs);
            
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
                moniteurs = (HashMap<Integer, Moniteur>) ois.readObject();
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




