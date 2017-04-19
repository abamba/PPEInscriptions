package menus;

import java.util.ArrayList;
import java.util.List;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuEquipe {

	static Connect co = Inscriptions.getInscriptions().getConnect();
	static List<Competition> comp = new ArrayList<Competition>();
	static List<Candidat> cand = new ArrayList<Candidat>();
	
	static Competition choix_comp;
	static Candidat choix_cand;
	
	public static Candidat choixCand(Boolean sub)
	{
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
		co.afficheComp();
		Competition choix;
		int choix_int;
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez une comp�tition : ");
		while (choix_int < 1 || choix_int > comp.size())
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez une comp�tition : ");
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
	
	static Option getOptionComposition()
	{
		Option Composition = new Option("Personnes qui composent l'�quipe", "1", getActionComposition());
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
		Option ListeComp = new Option("Comp�titions auxquelles l'�quipe est inscrite", "2", getActionListeComp());
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
		Option inscComp = new Option("Inscrire cette �quipe � une comp�tition", "3", getActioninscComp());
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
		Option desinscComp = new Option("D�sinscrire cette �quipe d'une comp�tition", "4", getActiondesinscComp());
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
		Option suppEquipe = new Option("Supprimer l'�quipe", "7", getActionsuppEquipe());
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
