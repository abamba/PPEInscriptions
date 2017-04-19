package menus;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;

import java.util.ArrayList;
import java.util.List;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {
	static Connect co = Inscriptions.getInscriptions().getConnect();
	
	static List<Competition> comp = new ArrayList<Competition>();
	static List<Candidat> cand = new ArrayList<Candidat>();
	
	static Competition choix_comp;
	static Candidat choix_cand;
	
	public static Candidat choixCand(Boolean sub)
	{
		// TODO afficheCand();
		if(sub)
			co.afficheEq();
		else 
			co.affichePers();
		Candidat choix;
		int choix_int;
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
		while (choix_int < 1 || choix_int > cand.size())
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
		}
		choix = cand.get(choix_int-1);
		return choix;
	}
	
	public static Competition choixComp()
	{
		System.out.println(comp);
		co.afficheComp();
		Competition choix;
		int choix_int;
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez une compétition : ");
		while (choix_int < 1 || choix_int > comp.size())
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez une compétition : ");
		}
		choix = comp.get(choix_int-1);
		return choix;
	}
	
	public static void reset()
	{
		comp.clear();
		comp.addAll(Inscriptions.getInscriptions().getCompetitions());
		cand.clear();
		cand.addAll(Inscriptions.getInscriptions().getCandidats());
	}
	
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
				choix_cand = choixCand();
				choix_comp = choixComp();
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
				choix_cand = choixCand();
				choix_comp = choixComp();
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
				co.afficheComp();
				choix_comp = choixComp();
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
