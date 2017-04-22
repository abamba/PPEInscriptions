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
		MenuPersonne menupers = new MenuPersonne();
		menupers.ajoutmenu();
		MenuCompetition menucomp = new MenuCompetition();
		menucomp.ajoutmenu();
		MenuInscriptions menuinsc = new MenuInscriptions();
		menuinsc.ajoutmenu();
		menuIndex.start();
	}
	
	public static Candidat choixCand()
	{
		Candidat choix;
		int choix_int;
		affCand();
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
		while (choix_int < 1 || choix_int > cand.size())
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
		}
		choix = cand.get(choix_int-1);
		return choix;
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
		int i = 0;
		if(sub)
		{
			affEq();
			for(Candidat c : eq)
			{
				i++;
			}
		}
		else
		{
			affPers();
			for(Candidat c : pers)
			{
				i++;
			}
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
	
	public static void affPers() {
		int i = 0;
		for(Candidat c : pers)
		{
			i++;
			System.out.println(i+" | "+c.getNom()+" | "+c.getPrenom());
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
		int i = 0;
		affComp();
		for(Competition c : comp)
		{
			i++;
		}
		Competition choix;
		int choix_int;
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez une compétition : ");
		while (choix_int < 1 || choix_int > i)
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez une compétition : ");
		}
		choix = comp.get(choix_int-1);
		return choix;
	}
	
	public static void affComp() {
		int i = 0;
		for(Competition c : comp)
		{
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
		Boolean boo;
		String choix_boo = utilitaires.EntreesSorties.getString("");
		while (!(choix_boo.equals("0")||choix_boo.equals("1")))
				choix_boo = utilitaires.EntreesSorties.getString("Erreur. Le résultat doit être 0 ou 1.");
		if(choix_boo.equals("0"))
			boo = false;
		else
			boo = true;
		return boo;
	}
	
	public static LocalDate writeDate()
	{
		LocalDate date = LocalDate.parse(utilitaires.EntreesSorties.getString(""), formatter);
		
		return date;
	}
	
}