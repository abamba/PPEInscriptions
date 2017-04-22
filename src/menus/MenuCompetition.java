package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import javafx.beans.value.WritableBooleanValue;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition extends MenuIndex {	
	static Competition choix_comp;
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
				reset();
				choix_comp = choixComp();
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
				reset();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
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
				reset();
				co.afficheComp();
				choix_comp = choixComp();
				choix_cand = choixCand(choix_comp.estEnEquipe());
				co.desinscComp(choix_comp, choix_cand);
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
				reset();
				choix_comp = choixComp();
				
				// Le nom
				System.out.println("Choisir un nom (vide pour ne pas modifier)");
				String nom = writeString();
				if (nom.length()>0)
					choix_comp.setNom(nom);
				
				// La date de cloture
				System.out.println("Choisir une date");
				choix_comp.setDateCloture(writeDate());
				
				// En équipe
				System.out.println("La compétition est-elle en équipe? (0/1)");
				choix_comp.setEnEquipe(writeBoo());
				
				co.modComp(choix_comp);
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
				reset();
				co.afficheComp();
				choix_comp = choixComp();
				co.supprComp(choix_comp);
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
