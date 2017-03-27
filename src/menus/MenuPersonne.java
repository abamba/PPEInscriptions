package menus;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuPersonne {
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Personne", "1");
		// INSCRIPTIONS
		
		Option getListeComp = new Option("Compétitions auxquelles il est inscrit", "1"); 
		Option inscComp = new Option("Inscrire ce candidat quelque part", "2"); 
		Option desinscComp = new Option("Désinscrire ce candidat de quelque part", "3"); 
		Option modNom = new Option("Changer le nom", "4"); 
		Option modMail = new Option("Changer l'email", "5"); 
		Option suppPersonne = new Option("Supprimer", "6");  
		
		inscriptions.ajoute(getListeComp);
		inscriptions.ajoute(inscComp);
		inscriptions.ajoute(desinscComp);
		inscriptions.ajoute(modNom);
		inscriptions.ajoute(modMail);
		inscriptions.ajoute(suppPersonne);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PATÉ LUNAIRE INSCRIRE - - - - - - - - - -
		
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
		
		suppPersonne.setAction(new Action()
		{
			public void optionSelectionnee() {
				//
			}
		});
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
