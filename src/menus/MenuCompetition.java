package menus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import inscriptions.Candidat;
import inscriptions.Competition;
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
				if(choix_comp!=null)
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
				if(choix_comp!=null)
					choix_cand = choixCand(choix_comp.estEnEquipe());
				if(choix_comp!=null&&choix_cand!=null)
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
				choix_comp = choixComp();
				List<Candidat> candInscrits = new ArrayList<Candidat>();
				if(choix_comp!=null)
				{
					candInscrits.addAll(co.getlisteCandidat(choix_comp));
					int i = 0;
					for (Candidat c : candInscrits)
					{
						System.out.println(i+1+" | "+c.getNom());
						i++;
					}
					if(i > 0)
					{
						Candidat choix;
						int choix_int;
						choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
						while (choix_int < 1 || choix_int > i)
						{
							choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
						}
						choix = candInscrits.get(choix_int-1);
						if(choix_comp!=null)
							co.desinscComp(choix_comp, choix);
					}
					else
						System.out.println("Personne n'est inscrit ici!");
				}
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
				if (choix_comp!=null)
				{
					// Le nom
					System.out.println("Choisir un nom (vide pour ne pas modifier)");
					String nom = writeString();
					if (nom.length()>0)
						choix_comp.setNom(nom);
					
					// La date de cloture
					System.out.println("Choisir une date");
					LocalDate date = writeDate();
					if(date!=null)
						choix_comp.setDateCloture(date);
					
					// En équipe
					System.out.println("La compétition est-elle en équipe? (0/1)");
					choix_comp.setEnEquipe(writeBoo());
					if(choix_comp!=null)
						co.modComp(choix_comp);
				}
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
				choix_comp = choixComp();
				if(choix_comp!=null)
					co.supprComp(choix_comp);
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Competition", "2");

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
