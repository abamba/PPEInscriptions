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
	
	static Option getOptionModifierCand()
	{
		Option ModifierCand = new Option("Modifier le candidat", "4", getActionModifierCand());
		return ModifierCand;
	}
	
	static Action getActionModifierCand()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_cand = choixCand();
				
				// Le nom
				System.out.println("Choisir un nom (vide pour ne pas modifier)");
				String nom = writeString();
				if (nom.length()>0)
					choix_cand.setNom(nom);
				
				// Le prénom
				System.out.println("Choisir un prénom (vide pour ne pas modifier)");
				String prenom = writeString();
				if (prenom.length()>0)
					choix_cand.setPrenom(prenom);
				
				// En équipe
				System.out.println("Choisir un mail (vide pour ne pas modifier)");
				String mail = writeString();
				if (mail.length()>0)
					choix_cand.setMail(mail);
				
				co.modPers(choix_cand);
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
	
	static Option getOptionsuppPersonne()
	{
		Option suppPersonne = new Option("Supprimer", "5", getActionsuppPersonne());
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
		inscriptions.ajoute(getOptionModifierCand());
		inscriptions.ajoute(getOptionsuppPersonne());
		inscriptions.ajouteRevenir("r");
		
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
