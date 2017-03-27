package menus;

import persistance.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuInscriptions {
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Inscription", "4");
		
		Option createComp = new Option("Créer une compétition", "1"); 
		Option createCand = new Option("Créer un candidat", "2"); 
		Option createEquipe = new Option("Créer une équipe", "3");
		
		inscriptions.ajoute(createComp); 
		inscriptions.ajoute(createCand);
		inscriptions.ajoute(createEquipe);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PATÉ LUNAIRE INSCRIRE - - - - - - - - - -
		
		createComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		createCand.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		createEquipe.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
