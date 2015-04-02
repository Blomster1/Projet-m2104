package ProjetFFCAM;


import java.util.Scanner;

public class MenuFFCAM {
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        
	    	Scanner sc = new Scanner(System.in);
	        	
               //création d'un FFCAM ici
	    	FFCAM ff = new FFCAM();
//                //ajout d'un moniteur dans le ffcam
                ff.nouveauMoniteur();
                ff.nouveauMoniteur();

			int choix;
			do {
                            
			System.out.println("\n****************************************************************");
			System.out.println("    *  Fédération Francaise des Clubs Alpins et de Montagne    *");
			System.out.println("****************************************************************");
			System.out.println("      * 1- Créer un nouveau CAF                                *");
			System.out.println("      * 2- Créer une nouvelle activité                         *");
			System.out.println("      * 3- Ajouter une activité proposée par un CAF            *");
			System.out.println("      * 4- Consulter les informations sur un CAF               *");
			System.out.println("      * 5- Consulter toutes les informations sur une activité  *");
			
                        System.out.println("****************************************************************");
			System.out.println("      * 0- Quitter                                             *");
			System.out.println("****************************************************************");
			System.out.print("      Votre Choix : ");
			
			choix = sc.nextInt();
			switch (choix) {
				case 1: {
					if (! ff.loadDB()) { ff.newDB();}
					ff.nouveauCAF(); 
                                        ff.updateDB();
                                        break; }
                                case 2: {
                                       if (! ff.loadDB()) { ff.newDB();}
					ff.nouvelleActivite();
                                        ff.updateDB();
                                        break; }
                                case 3: {
                                        if (! ff.loadDB()) { ff.newDB();}
                                        ff.ajouterActivite();
                                        ff.updateDB();
                                        break; }
                                case 4: {
                                        if (! ff.loadDB()) { ff.newDB();}
                                        ff.afficheInfos();
                                        ff.updateDB();
                                        break; }
                                case 5: {
                                        if (! ff.loadDB()) { ff.newDB();}
                                        ff.afficheInfosAct();
                                        ff.updateDB();
                                        break; }
				default:
					break;
				} // switch.newDB(
                        
                        
			} while (choix != 0);	
                        
	    }
}
