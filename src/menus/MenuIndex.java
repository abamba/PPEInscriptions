package menus;

import utilitaires.ligneDeCommande.Menu;

public class MenuIndex {

	public static Menu menuIndex = new Menu("Index");

	public void menuAdd(Menu m)
	{
		menuIndex.ajoute(m);
	}
	
	public static void Index()
	{
		MenuPersonne menupers = new MenuPersonne();
		menupers.ajoutmenu();
		MenuEquipe menuequipe = new MenuEquipe();
		menuequipe.ajoutmenu();
		MenuCompetition menucomp = new MenuCompetition();
		menucomp.ajoutmenu();
		MenuInscriptions menuinsc = new MenuInscriptions();
		menuinsc.ajoutmenu();
		menuIndex.start();
	}	
}