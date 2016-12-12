package menus;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {

	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Competition", "3");
		// INSCRIPTIONS
		
		Option getCandidats_insc = new Option("Tout les candidats inscrits � une comp�tition", "1"); 
		Option desinsc_candid = new Option("D�sinscrire un candidat d'une comp�tition", "2"); 
		Option addCompet_candidat = new Option("Inscrire un candidat � une comp�tition", "3"); 
		
		inscriptions.ajoute(getCandidats_insc); 
		inscriptions.ajoute(desinsc_candid);
		inscriptions.ajoute(addCompet_candidat);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PAT� LUNAIRE INSCRIRE - - - - - - - - - -
		
		getCandidats_insc.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la comp�tition: ");
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
