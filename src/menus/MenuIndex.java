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
		MenuEquipe menuequipe = new MenuEquipe();
		menuequipe.ajoutmenu();
		MenuCompetition menucomp = new MenuCompetition();
		menucomp.ajoutmenu();
		MenuInscriptions menuinsc = new MenuInscriptions();
		menuinsc.ajoutmenu();
		menuIndex.start();
	}
	
	public static Candidat choixCand()
	{
		co.afficheCand();
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
	
	public static Candidat choixCand(Boolean sub)
	{
		int i = 0;
		if(sub)
			for(Candidat c : cand)
			{
				if(c.getSub().equalsIgnoreCase("s"))
				{
					i++;
					System.out.println(i+" | "+c.getNom());
				}
			}
		else 
			for(Candidat c : cand)
			{
				if(c.getSub().equalsIgnoreCase("p"))
				{
					i++;
					System.out.println(i+" | "+c.getNom()+" | "+c.getPrenom());
				}
			}
		Candidat choix;
		int choix_int;
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez un candidat : ");
		while (choix_int < 1 || choix_int > i)
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez un candidat : ");
		}
		choix = cand.get(choix_int-1);
		return choix;
	}
	
	public static Competition choixComp()
	{
		int i = 0;
		for(Competition c : comp)
		{
			i++;
			System.out.println(i+" | "+c.getNom()+" | "+c.getDateCloture());
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
	
	public static void reset()
	{
		comp.clear();
		comp.addAll(Inscriptions.getInscriptions().getCompetitions());
		cand.clear();
		cand.addAll(Inscriptions.getInscriptions().getCandidats());
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