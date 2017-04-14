package menus;

import inscriptions.Inscriptions;
import java.util.Scanner;
import java.util.Set;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {
	int comp;	

	static Option getOptionListeCandidat()
	{
		Option listeCandidat = new Option("Liste des candidats", "1", getActionListeCandidat());
		return listeCandidat;
	}
	
	static Action getActionListeCandidat()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptioninscrireCandidat()
	{
		Option inscrireCandidat = new Option("Inscrire un candidat", "2", getActioninscrireCandidat());
		return inscrireCandidat;
	}
	
	static Action getActioninscrireCandidat()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptiondesinscCandidat()
	{
		Option desinscCandidat = new Option("D�sincrire un candidat", "3", getActiondesinscCandidat());
		return desinscCandidat;
	}
	
	static Action getActiondesinscCandidat()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptionModifierComp()
	{
		Option ModifierComp = new Option("Modifier la comp�tition", "4", getActionModifierComp());
		return ModifierComp;
	}
	
	static Action getActionModifierComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	static Option getOptionsupprComp()
	{
		Option supprComp = new Option("Supprimer la comp�tition", "5", getActionsupprComp());
		return supprComp;
	}
	
	static Action getActionsupprComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				int a = utilitaires.EntreesSorties.getInt("Saisissez la premi�re op�rande : "),
						b = utilitaires.EntreesSorties.getInt("Saisissez la deuxi�me op�rande : ");
				System.out.println("" + a + " + " + b + " = " + (a+b));
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Competition", "3");

		// Code �l�gant
		
		inscriptions.ajoute(getOptionListeCandidat());
		inscriptions.ajoute(getOptioninscrireCandidat());
		inscriptions.ajoute(getOptiondesinscCandidat());
		inscriptions.ajoute(getOptionModifierComp());
		inscriptions.ajoute(getOptionsupprComp());
		inscriptions.ajouteRevenir("r");
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
