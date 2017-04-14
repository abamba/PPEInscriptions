package menus;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuEquipe {

	static Option getOptionComposition()
	{
		Option Composition = new Option("Personnes qui composent l'�quipe", "1", getActionComposition());
		return Composition;
	}
	
	static Action getActionComposition()
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
	
	static Option getOptionListeComp()
	{
		Option Composition = new Option("Comp�titions auxquelles l'�quipe est inscrite", "2", getActionListeComp());
		return Composition;
	}
	
	static Action getActionListeComp()
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
	
	static Option getOptioninscComp()
	{
		Option Composition = new Option("Inscrire cette �quipe � une comp�tition", "3", getActioninscComp());
		return Composition;
	}
	
	static Action getActioninscComp()
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
	
	static Option getOptiondesinscComp()
	{
		Option Composition = new Option("D�sinscrire cette �quipe d'une comp�tition", "4", getActiondesinscComp());
		return Composition;
	}
	
	static Action getActiondesinscComp()
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
	
	static Option getOptionmodNom()
	{
		Option Composition = new Option("Modifier le nom", "5", getActionmodNom());
		return Composition;
	}
	
	static Action getActionmodNom()
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
	
	static Option getOptionmodMail()
	{
		Option Composition = new Option("Modifier l'e-mail", "6", getActionmodMail());
		return Composition;
	}
	
	static Action getActionmodMail()
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
	
	static Option getOptionsuppEquipe()
	{
		Option Composition = new Option("Supprimer l'�quipe", "7", getActionsuppEquipe());
		return Composition;
	}
	
	static Action getActionsuppEquipe()
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
		Menu inscriptions = new Menu("Menu Equipe", "2");
		
		// INSCRIPTIONS
		
		inscriptions.ajoute(getOptionComposition());
		inscriptions.ajoute(getOptionListeComp());
		inscriptions.ajoute(getOptioninscComp());
		inscriptions.ajoute(getOptiondesinscComp());
		inscriptions.ajoute(getOptionmodNom());
		inscriptions.ajoute(getOptionmodMail());
		inscriptions.ajoute(getOptionsuppEquipe());
		inscriptions.ajouteRevenir("r");

		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
