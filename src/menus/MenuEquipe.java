package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuEquipe extends MenuIndex {
	static Competition choix_comp;
	static Candidat choix_cand;
	
	static Option getOptionComposition()
	{
		Option Composition = new Option("Personnes qui composent l'équipe", "1", getActionComposition());
		return Composition;
	}
	
	static Action getActionComposition()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.Composition(choix_cand);
			}
		};
	}
	
	static Option getOptionListeComp()
	{
		Option ListeComp = new Option("Compétitions auxquelles l'équipe est inscrite", "2", getActionListeComp());
		return ListeComp;
	}
	
	static Action getActionListeComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.ListeComp(choix_cand);
			}
		};
	}
	
	static Option getOptioninscComp()
	{
		Option inscComp = new Option("Inscrire cette équipe à une compétition", "3", getActioninscComp());
		return inscComp;
	}
	
	static Action getActioninscComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.inscComp(choix_cand, choix_comp);
			}
		};
	}
	
	static Option getOptiondesinscComp()
	{
		Option desinscComp = new Option("Désinscrire cette équipe d'une compétition", "4", getActiondesinscComp());
		return desinscComp;
	}
	
	static Action getActiondesinscComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.desinscComp(choix_comp, choix_cand);
			}
		};
	}
	
	static Option getOptionmodNom()
	{
		Option modNom = new Option("Modifier le nom", "5", getActionmodNom());
		return modNom;
	}
	
	static Action getActionmodNom()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.modPers(choix_cand);
			}
		};
	}
	
	static Option getOptionmodMail()
	{
		Option modMail = new Option("Modifier l'e-mail", "6", getActionmodMail());
		return modMail;
	}
	
	static Action getActionmodMail()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.modPers(choix_cand);
			}
		};
	}
	
	static Option getOptionsuppEquipe()
	{
		Option suppEquipe = new Option("Supprimer l'équipe", "7", getActionsuppEquipe());
		return suppEquipe;
	}
	
	static Action getActionsuppEquipe()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.delCandidat(choix_cand);
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
