package menus;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuEquipe {

	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Equipe", "2");
		// INSCRIPTIONS
		
		Option getComposition = new Option("Personnes qui composent l'équipe", "1");
		Option getListeComp = new Option("Compétitions auxquelles l'équipe est inscrite", "2"); 
		Option inscComp = new Option("Inscrire ce candidat quelque part", "3"); 
		Option desinscComp = new Option("Désinscrire ce candidat de quelque part", "4"); 
		Option modNom = new Option("Changer le nom", "5"); 
		Option modMail = new Option("Changer l'email", "6");
		Option suppEquipe = new Option("Supprimer", "7"); 

		inscriptions.ajoute(getComposition);
		inscriptions.ajoute(getListeComp);
		inscriptions.ajoute(inscComp);
		inscriptions.ajoute(desinscComp);
		inscriptions.ajoute(modNom);
		inscriptions.ajoute(modMail);
		inscriptions.ajoute(suppEquipe);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PATÉ LUNAIRE INSCRIRE - - - - - - - - - -
		
		getComposition.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		getListeComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		inscComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		desinscComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		modNom.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		modMail.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		suppEquipe.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});

		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
