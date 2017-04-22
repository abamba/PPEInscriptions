package menus;

import java.util.ArrayList;
import java.util.List;

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
	
	// add choix entre eq et pers ?
	static Action getActionListeComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				choix_cand = choixCand();
				if(choix_cand!=null)
				{
					co.ListeComp(choix_cand);
				}
				else
					System.out.println("Personne n'est inscrit ici !");
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
				if(choix_comp!=null)
				{
					choix_cand = choixCand(choix_comp.estEnEquipe()); 
					if(choix_cand!=null) 
						co.inscComp(choix_cand, choix_comp);
					else
						System.out.println("Personne n'est inscrit ici !");
					
				}
				else
					System.out.println("Il n'y a pas de compétitions !");
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
				if(choix_cand!=null)
				{
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
				else
					System.out.println("Personne n'est inscrit ici !");
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
				choix_cand = choixCand();
				if(choix_cand!=null)
				{
					co.delCandidat(choix_cand);
				}
				else
					System.out.println("Personne n'est inscrit ici !");
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Candidat", "3");
		
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
