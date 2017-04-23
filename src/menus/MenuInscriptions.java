package menus;

import java.time.LocalDate;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuInscriptions extends MenuIndex {
	static Competition choix_comp;
	static Candidat choix_cand;

	static Option getOptioncreateComp()
	{
		Option createComp = new Option("Cr�er une comp�tition", "1", getActioncreateComp());
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
				System.out.println("Choisissez une date (aaaa-mm-jj) : ");
				choix_compet.setDateCloture(writeDate());
				// En �quipe
				System.out.println("Est-elle en �quipe? (0/1)");
				choix_compet.setEnEquipe(writeBoo());
				
				co.createComp(choix_compet);
			}
		};
	}
	
	static Option getOptioncreateCand()
	{
		Option createCand = new Option("Cr�er un candidat", "2", getActioncreateCand());
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
				
				// Le pr�nom
				System.out.println("Choisissez un pr�nom : ");
				choix_candid.setPrenom(writeString());
				
				// Le mail
				System.out.println("Choisissez un mail : ");
				choix_candid.setMail(writeString());
				
				choix_candid.setSub(false);
				co.createPers(choix_candid);
			}
		};
	}
	
	static Option getOptioncreateEquipe()
	{
		Option createEquipe = new Option("Cr�er une �quipe", "3", getActioncreateEquipe());
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
				
				choix_candid.setSub(true);
				co.createPers(choix_candid);
			}
		};
	}
	
	static Option getOptionaffComp()
	{
		Option affComp = new Option("Afficher les comp�titions", "4", getActionaffComp());
		return affComp;
	}
	
	static Action getActionaffComp()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				affComp();
			}
		};
	}
	
	static Option getOptionaffCand()
	{
		Option affCand = new Option("Afficher les candidats", "5", getActionaffCand());
		return affCand;
	}
	
	static Action getActionaffCand()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				affPers();
			}
		};
	}
	
	static Option getOptionaffEquipe()
	{
		Option affEquipe = new Option("Afficher les �quipes", "6", getActionaffEquipe());
		return affEquipe;
	}
	
	static Action getActionaffEquipe()
	{
		return new Action()
		{
			public void optionSelectionnee()
			{
				reset();
				affEq();
			}
		};
	}
	
	public void ajoutmenu()
	{
		Menu inscriptions = new Menu("Menu Inscription", "1");

		inscriptions.ajoute(getOptioncreateComp()); 
		inscriptions.ajoute(getOptioncreateCand());
		inscriptions.ajoute(getOptioncreateEquipe());
		inscriptions.ajoute(getOptionaffComp());
		inscriptions.ajoute(getOptionaffCand());
		inscriptions.ajoute(getOptionaffEquipe());
		inscriptions.ajouteRevenir("r");

		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
