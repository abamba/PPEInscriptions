package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuInscriptions {
	static Connect co = Inscriptions.getInscriptions().getConnect();
	static Competition choix_comp = new Competition(Inscriptions.getInscriptions(), null, null, false);
	static Candidat choix_cand;
	
	static Option getOptioncreateComp()
	{
		Option createComp = new Option("Créer une compétition", "1", getActioncreateComp());
		return createComp;
	}
	
	static Action getActioncreateComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.createComp(choix_comp);
			}
		};
	}
	
	static Option getOptioncreateCand()
	{
		Option createCand = new Option("Créer un candidat", "2", getActioncreateCand());
		return createCand;
	}
	
	static Action getActioncreateCand()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.createPers(choix_cand);
			}
		};
	}
	
	static Option getOptioncreateEquipe()
	{
		Option createEquipe = new Option("Créer une équipe", "3", getActioncreateEquipe());
		return createEquipe;
	}
	
	static Action getActioncreateEquipe()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.createEq(choix_cand);
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
