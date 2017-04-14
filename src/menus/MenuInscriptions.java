package menus;

import persistance.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuInscriptions {
	
	static Option getOptioncreateComp()
	{
		Option createComp = new Option("Cr�er une comp�tition", "1", getActioncreateComp());
		return createComp;
	}
	
	static Action getActioncreateComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la première opérande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxième opérande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptioncreateCand()
	{
		Option createCand = new Option("Cr�er un candidat", "2", getActioncreateCand());
		return createCand;
	}
	
	static Action getActioncreateCand()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la première opérande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxième opérande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptioncreateEquipe()
	{
		Option createEquipe = new Option("Cr�er une �quipe", "3", getActioncreateEquipe());
		return createEquipe;
	}
	
	static Action getActioncreateEquipe()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la première opérande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxième opérande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Inscription", "4");

		inscriptions.ajoute(getOptioncreateComp()); 
		inscriptions.ajoute(getOptioncreateCand());
		inscriptions.ajoute(getOptioncreateEquipe());
		inscriptions.ajouteRevenir("r");

		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
