package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuPersonne extends MenuIndex {
	static Competition choix_comp;
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
				reset();
				choix_cand = choixCand();
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
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
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
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
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
				reset();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				String choix_nom = utilitaires.EntreesSorties.getString("Choisissez un nom : "); 
				choix_cand.setNom(choix_nom);
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
				reset();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				String choix_mail = utilitaires.EntreesSorties.getString("Choisissez un mail : ");
				choix_cand.setMail(choix_mail);
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
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
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
