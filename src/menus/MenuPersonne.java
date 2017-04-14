package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuPersonne {
	static Connect co = Inscriptions.getInscriptions().getConnect();
	static Competition choix_comp = new Competition(Inscriptions.getInscriptions(), null, null, false);
	static Candidat choix_cand;
	
	static Option getOptionListeComp()
	{
		Option listeComp = new Option("Compétitions auxquelles il est inscrit", "1", getActionListeComp());
		return listeComp;
	}
	
	static Action getActionListeComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.ListeComp(choix_cand);
			}
		};
	}
	
	static Option getOptioninscComp()
	{
		Option inscComp = new Option("Inscrire ce candidat quelque part", "2", getActioninscComp());
		return inscComp;
	}
	
	static Action getActioninscComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.inscComp(choix_cand, choix_comp);
			}
		};
	}
	
	static Option getOptiondesinscComp()
	{
		Option desinscComp = new Option("Désinscrire ce candidat de quelque part", "3", getActiondesinscComp());
		return desinscComp;
	}
	
	static Action getActiondesinscComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.desinscComp(choix_comp, choix_cand);
			}
		};
	}
	
	static Option getOptionmodNom()
	{
		Option modNom = new Option("Changer le nom", "4", getActionmodNom());
		return modNom;
	}
	
	static Action getActionmodNom()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.modPers(choix_cand);
			}
		};
	}
	
	static Option getOptionmodMail()
	{
		Option modMail = new Option("Changer l'email", "5", getActionmodMail());
		return modMail;
	}
	
	static Action getActionmodMail()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.modPers(choix_cand);
			}
		};
	}
	
	static Option getOptionsuppPersonne()
	{
		Option suppPersonne = new Option("Supprimer", "6", getActionsuppPersonne());
		return suppPersonne;
	}
	
	static Action getActionsuppPersonne()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				co.supprCandidat(choix_comp, choix_cand);
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Personne", "1");
		
		inscriptions.ajoute(getOptionListeComp());
		inscriptions.ajoute(getOptioninscComp());
		inscriptions.ajoute(getOptiondesinscComp());
		inscriptions.ajoute(getOptionmodNom());
		inscriptions.ajoute(getOptionmodMail());
		inscriptions.ajoute(getOptionsuppPersonne());
		inscriptions.ajouteRevenir("r");
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
