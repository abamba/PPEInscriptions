package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;

import java.util.Scanner;
import java.util.Set;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {
	int comp;	
	static Connect co = Inscriptions.getInscriptions().getConnect();
	static Competition choix_comp = new Competition(Inscriptions.getInscriptions(), null, null, false);
	static Candidat choix_cand;

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
				co.listeCandidat(choix_comp);
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
				co.inscrireCandidat(choix_cand, choix_comp);
			}
		};
	}
	
	static Option getOptiondesinscCandidat()
	{
		Option desinscCandidat = new Option("Désincrire un candidat", "3", getActiondesinscCandidat());
		return desinscCandidat;
	}
	
	static Action getActiondesinscCandidat()
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
	
	static Option getOptionModifierComp()
	{
		Option ModifierComp = new Option("Modifier la compétition", "4", getActionModifierComp());
		return ModifierComp;
	}
	
	static Action getActionModifierComp()
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
	
	static Option getOptionsupprComp()
	{
		Option supprComp = new Option("Supprimer la compétition", "5", getActionsupprComp());
		return supprComp;
	}
	
	static Action getActionsupprComp()
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
		Menu inscriptions = new Menu("Menu Competition", "3");

		// Code élégant
		
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
