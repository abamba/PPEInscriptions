package menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
	
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
		choix_int = utilitaires.EntreesSorties.getInt("Choisissez une compétition : ");
		while (choix_int < 1 || choix_int > comp.size())
		{
			choix_int = utilitaires.EntreesSorties.getInt("Erreur. Choisissez une compétition : ");
		}
		choix = comp.get(choix_int-1);
		return choix;
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
				Competition choix_compet = new Competition(Inscriptions.getInscriptions(),"",LocalDate.now(),false);
				// Le nom
				System.out.println("Choisissez un nom : ");
				choix_compet.setNom(writeString());
				// La date cloture
				System.out.println("Choisissez une date : ");
				choix_compet.setDateCloture(writeDate());
				// En équipe
				System.out.println("Est-elle en équipe? (0/1)");
				choix_compet.setEnEquipe(writeBoo());
				
				co.createComp(choix_compet);
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
				Candidat choix_candid = new Candidat(Inscriptions.getInscriptions(),"");
				
				// Le nom
				System.out.println("Choisissez un nom : ");
				choix_candid.setNom(writeString());
				
				// Le prénom
				System.out.println("Choisissez un prénom : ");
				choix_candid.setPrenom(writeString());
				
				// Le mail
				System.out.println("Choisissez un mail : ");
				choix_candid.setMail(writeString());
				
				co.createPers(choix_candid);
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
				Candidat choix_candid = new Candidat(Inscriptions.getInscriptions(),"");
				
				// Le nom
				System.out.println("Choisissez un nom : ");
				choix_candid.setNom(writeString());
				
				// Le mail
				System.out.println("Choisissez un mail : ");
				choix_candid.setMail(writeString());
				
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
