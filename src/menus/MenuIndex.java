package menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import persistance.Connect;
import utilitaires.ligneDeCommande.Menu;

public class MenuIndex {

	static Connect co = Inscriptions.getInscriptions().getConnect();
	static List<Competition> comp = new ArrayList<Competition>();
	static List<Candidat> cand = new ArrayList<Candidat>();
	static List<Candidat> eq = new ArrayList<Candidat>();
	static List<Candidat> pers = new ArrayList<Candidat>();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
	
	public static Menu menuIndex = new Menu("Index");

	public void menuAdd(Menu m)
	{
		menuIndex.ajoute(m);
	}
	
	public static void Index()
	{
		MenuInscriptions menuinsc = new MenuInscriptions();
		menuinsc.ajoutmenu();
		MenuCompetition menucomp = new MenuCompetition();
		menucomp.ajoutmenu();
		MenuPersonne menupers = new MenuPersonne();
		menupers.ajoutmenu();
		menuIndex.start();
	}
	
	public static Candidat choixCand()
	{
		if (cand.size()>0)
		{
			Candidat choix = null;
			if(cand.size()>0)
			{
				int choix_int;
				affCand();
				choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
				while (choix_int < 1 || choix_int > cand.size())
				{
					choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
				}
				choix = cand.get(choix_int-1);
			}
			return choix;
		}
		else
		{
			return null;
		}
	}
	
	public static void affCand() {
		int i = 0;
		for(Candidat c : cand)
		{
			i++;
			if(c.getSub())
				System.out.println(i+" | "+c.getNom());
			else
				System.out.println(i+" | "+c.getNom()+" | "+c.getPrenom());
		}
	}
	
	public static Candidat choixCand(Boolean sub)
	{
		if(cand.size()>0)
		{
			int i = 0;
			if(sub)
			{
				affEq();
				i = eq.size();
			}
			else
			{
				affPers();
				i = pers.size();
			}
			Candidat choix;
			int choix_int;
			choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
			while (choix_int < 1 || choix_int > i)
			{
				choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
			}
			if(sub)
				choix = eq.get(choix_int-1);
			else
				choix = pers.get(choix_int-1);
			System.out.println(choix.getId()+choix.getNom());
			return choix;
		}
		else
		{
			return null;
		}
	}
	
	public static void affPers() {
		int i = 0;
		for(Candidat c : pers)
		{
			if(!c.getSub())
			{
				i++;
				System.out.println(i+" | "+c.getNom()+" | "+c.getPrenom());
			}
		}
	}

	public static void affEq() {
		int i = 0;
		for(Candidat c : eq)
		{
			i++;
			System.out.println(i+" | "+c.getNom());
		}
	}

	public static Competition choixComp()
	{
		Competition choix;
		if(comp.size()>0)
		{
			int i = 0;
			affComp();
			i = comp.size();
			int choix_int;
			choix_int = utilitaires.EntreesSorties.getInt("Choisissez une compétition : ");
			while (choix_int < 1 || choix_int > i)
			{
				choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez une compétition : ");
			}
			choix = comp.get(choix_int-1);
			return choix;
		}
		else
		{
			return null;
		}
	}
	
	public static void affComp() {
		int i = 0;
		for(Competition c : comp)
		{
			i++;
			System.out.println(i + " | "+c.getNom());
		}
	}

	public static void reset()
	{
		comp.clear();
		comp.addAll(Inscriptions.getInscriptions().getCompetitions());
		cand.clear();
		cand.addAll(Inscriptions.getInscriptions().getCandidats());
		eq.clear();
		pers.clear();
		for (Candidat c : cand)
		{
			if(c.getSub())
			{
				eq.add(c);
			}
			else if(!c.getSub())
			{
				pers.add(c);
			}
		}
	}
	
	public static String writeString()
	{
		return utilitaires.EntreesSorties.getString("");
	}
	
	public static Boolean writeBoo()
	{
		Boolean boo = true;
		String choix_boo = utilitaires.EntreesSorties.getString("");
		while (!(choix_boo.equals("0")||choix_boo.equals("1")))
				choix_boo = utilitaires.EntreesSorties.getString("Erreur. Le résultat doit être 0 ou 1.");
		if(choix_boo.equals("0"))
			boo = false;
		return boo;
	}
	
	public static LocalDate writeDate()
	{
		String dated = utilitaires.EntreesSorties.getString("");
		LocalDate date = null;
		if(dated.length()==10)
			date = LocalDate.parse(dated, formatter);
		return date;
	}
	
}