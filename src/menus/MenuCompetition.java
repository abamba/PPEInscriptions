package menus;

import inscriptions.Inscriptions;
import java.util.Scanner;
import java.util.Set;

import inscriptions.Candidat;
import inscriptions.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {
	int comp = -1;
	public void ajoutmenu()
	{
		Inscriptions insc = Inscriptions.getInscriptions();
		Connect co = new Connect();
		Menu inscriptions = new Menu("Menu Competition", "3");
		
		// INSCRIPTIONS
		Option choixComp = new Option("Choisir une comp�tition", "1"); 
		Option getCandidats_insc = new Option("Tout les candidats inscrits � une comp�tition", "2"); 
		Option addCompet_candidat = new Option("Inscrire un candidat � une comp�tition", "3"); 
		Option desinsc_candid = new Option("D�sinscrire un candidat d'une comp�tition", "4"); 
		
		inscriptions.ajoute(choixComp);
		inscriptions.ajoute(getCandidats_insc); 
		inscriptions.ajoute(addCompet_candidat);
		inscriptions.ajoute(desinsc_candid);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PAT� LUNAIRE INSCRIRE - - - - - - - - - -
		
		choixComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				insc.afficheCompetitions();
				Scanner reader = new Scanner(System.in);
				System.out.println("Choisir un id :");
				int n = reader.nextInt();
				comp = n;
			}
		});
		
		getCandidats_insc.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		desinsc_candid.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID de la comp�tition: ");
			}
		});
		
		addCompet_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID de la comp�tition: ");
			}
		});
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
