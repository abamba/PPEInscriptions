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

public class MenuInscriptions {
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
				// TODO
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
				// TODO
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
				// TODO
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
