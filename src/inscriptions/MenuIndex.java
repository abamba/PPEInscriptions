package inscriptions;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuIndex {

	/* Bonjour Boo.
	 * Menu nom = new Menu("Texte à afficher en haut du menu","Bouton à cliquer") Pour créer un menu
	 * nom.ajoute(option/menu) Pour ajouter une option ou un sous menu au menu
	 * Copie colle une des actions en dessous si tu comptes ajouter une action.
	 * Il est important que tout soit avant le menuIndex.start();
	 */
	
	static void Index()
	{
		Connect co = new Connect();
		Menu menuIndex = new Menu("Index");
		
		Menu candidat = new Menu("Menu Candidat", "1");
		Menu competition = new Menu("Menu Compétition", "2");
		Menu equipe = new Menu("Menu Equipe", "3");
		Menu inscriptions = new Menu("Menu Inscription", "4");
	
		menuIndex.ajoute(candidat);
		menuIndex.ajoute(competition);
		menuIndex.ajoute(equipe);
		menuIndex.ajoute(inscriptions);
		
		// CANDIDAT
		
		Option addEquipe_cand = new Option("Ajouter une équipe", "1");
		Option addPersonne_cand = new Option("Ajouter une personne", "2");
		Option del_candidat = new Option("Supprimer un  candidat", "3");
		Option getCompet_candidat = new Option("Avoir la liste des compétitions où est inscrit un candidat", "4");
		Option getNom_candidat = new Option("Avoir le nom d'un candidat", "5");
		Option setNom_candidat = new Option("Changer le nom d'un candidat", "6");
		Option getPrenom_candidat = new Option("Avoir le prénom d'un candidat", "7");
		Option setPrenom_candidat = new Option("Changer le prénom d'un candidat", "8");
		Option getMail_candidat = new Option("Avoir l'email d'un candidat", "9");
		Option setMail_candidat = new Option("Changer le mail d'un candidat", "10");
		Option getCandidat = new Option("Liste des candidats", "11");
		Option getCandidPersonnes = new Option("Liste des personnes", "12");
		Option getCandidEquipes = new Option("Liste des équipes", "13");
		
		candidat.ajoute(addEquipe_cand); 
		candidat.ajoute(addPersonne_cand);
		candidat.ajoute(del_candidat); 
		candidat.ajoute(getCompet_candidat); 
		candidat.ajoute(getNom_candidat);
		candidat.ajoute(setNom_candidat);
		candidat.ajoute(getPrenom_candidat);
		candidat.ajoute(setPrenom_candidat);
		candidat.ajoute(getMail_candidat);
		candidat.ajoute(setMail_candidat);
		candidat.ajoute(getCandidat);
		candidat.ajoute(getCandidPersonnes);
		candidat.ajoute(getCandidEquipes);
		candidat.ajouteRevenir("r");
		
		//COMPETITION
		
		Option create_compet = new Option("Créer une compétition", "1"); 
		Option insc_ouvert_compet = new Option("Vérifier si l'inscription est ouverte", "2");
		Option getListe_compet = new Option("Liste des compétitions", "3");
		Option getDateCloture_compet = new Option("Date de clôture d'une compétition", "4");
		Option setDateCloture_compet = new Option("Modifier la date de clôture d'une compétition", "5");
		Option delete_compet = new Option("Supprimer une compétition", "6");
		Option getNom_compet = new Option("Nom d'une compétition", "7");
		Option setNom_compet = new Option("Modifier le nom d'une compétition", "8"); 
		Option estEnEquipe_compet = new Option("Vérifier si une compétition est en equipe", "9"); 
		
		competition.ajoute(create_compet); 
		competition.ajoute(insc_ouvert_compet);
		competition.ajoute(getListe_compet);
		competition.ajoute(getDateCloture_compet);
		competition.ajoute(setDateCloture_compet); 
		competition.ajoute(delete_compet);
		competition.ajoute(getNom_compet); 
		competition.ajoute(setNom_compet);
		competition.ajoute(estEnEquipe_compet);
		competition.ajouteRevenir("r");
		
		// EQUIPE
		
		Option getEquipes_candidat = new Option("Avoir les équipes d'un candidat", "1"); 
		Option getMembres_squad = new Option("Avoir les membres d'une équipe", "2"); 
		Option addEquipe_candidat = new Option("Ajouter un membre à une équipe", "3"); 
		Option removeEquipe_candidat = new Option("Enlever un membre d'une équipe", "4"); 
		
		equipe.ajoute(getEquipes_candidat); 
		equipe.ajoute(getMembres_squad);
		equipe.ajoute(addEquipe_candidat);
		equipe.ajoute(removeEquipe_candidat);
		equipe.ajouteRevenir("r");
		
		// INSCRIPTIONS
		
		Option getCandidats_insc = new Option("Tout les candidats inscrits à une compétition", "1"); 
		Option desinsc_candid = new Option("Désinscrire un candidat d'une compétition", "2"); 
		Option addCompet_candidat = new Option("Inscrire un candidat à une compétition", "3"); 
		
		inscriptions.ajoute(getCandidats_insc); 
		inscriptions.ajoute(desinsc_candid);
		inscriptions.ajoute(addCompet_candidat);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PATÉ LUNAIRE CANDIDAT - - - - - - - - - -
		
		addEquipe_cand.setAction(new Action()
		{
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom: ");
				String prenom = utilitaires.EntreesSorties.getString("Saisissez le prénom: ");
				String mail = utilitaires.EntreesSorties.getString("Saisissez le mail: ");
				co.sql("call addEquipe_cand(\"" + nom + "\",\"" + prenom + "\",\"" + mail + "\")");
			}
		});
		
		addPersonne_cand.setAction(new Action()
		{
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom: ");
				String prenom = utilitaires.EntreesSorties.getString("Saisissez le prénom: ");
				String mail = utilitaires.EntreesSorties.getString("Saisissez le mail: ");
				co.sql("call addPersonne_cand(\"" + nom + "\",\"" + prenom + "\",\"" + mail + "\")");
			}
		});

		del_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call del_candidat("+id+")");
			}
		});

		getCompet_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call getCompet_candidat("+id+")");
			}
		});
		
		getNom_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call getNom_candidat("+id+")");
			}
		});

		setNom_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom: ");
				co.sql("call setNom_candidat("+id+",\""+nom+"\")");
			}
		});
		
		getPrenom_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call getPrenom_candidat("+id+")");
			}
		});
		
		setPrenom_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				String nom = utilitaires.EntreesSorties.getString("Saisissez le prénom: ");
				co.sql("call setPrenom_candidat("+id+",\""+nom+"\")");
			}
		});
		
		getMail_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call getMail_candidat("+id+")");
			}
		});
		
		setMail_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				String nom = utilitaires.EntreesSorties.getString("Saisissez le mail: ");
				co.sql("call setMail_candidat("+id+",\""+nom+"\")");
			}
		});
		
		getCandidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				co.sql("call getCandidat()");
			}
		});
		
		getCandidPersonnes.setAction(new Action()
		{
			public void optionSelectionnee() {
				co.sql("call getCandidPersonnes()");
			}
		});
		
		getCandidEquipes.setAction(new Action()
		{
			public void optionSelectionnee() {
				co.sql("call getCandidEquipes()");
			}
		});
		
		// - - - - - - - - - - PATÉ LUNAIRE COMPETITION - - - - - - - - - -
		
		create_compet.setAction(new Action()
		{
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom de la nouvelle compétition: ");
				String date = utilitaires.EntreesSorties.getString("Saisissez la date de cloture: ");
				int enEquipe = utilitaires.EntreesSorties.getInt("Compétition en équipe ?(0/1) ");
				co.sql("call create_compet(\"" + nom + "\",\"" + date + "\"," + enEquipe + ")");
			}
		});
		
		insc_ouvert_compet.setAction(new Action() // CELUI LA NE MARCHE PAS, DESOLE.
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call insc_ouvert("+id+")");
			}
		});
		
		getListe_compet.setAction(new Action()
		{
			public void optionSelectionnee() {
				co.sql("call getListeComp()");
			}
		});
		
		getDateCloture_compet.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call getDateCloture_compet("+id+")");
			}
		});
		
		setDateCloture_compet.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				String date = utilitaires.EntreesSorties.getString("Saisissez la date de cloture: ");
				co.sql("call setDateCloture_compet("+id+",\""+date+"\")");
			}
		});
		
		delete_compet.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call del_compet("+id+")");
			}
		});
		
		setNom_compet.setAction(new Action() // CELUI LA NE MARCHE PAS, DESOLE.
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nouveau nom de la compétition: ");
				co.sql("call setNom_compet("+id+",\""+nom+"\")");
			}
		});
		
		estEnEquipe_compet.setAction(new Action() // CELUI LA NE MARCHE PAS, DESOLE.
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call estEnEquipe("+id+")");
			}
		});
		
		// - - - - - - - - - - PATÉ LUNAIRE EQUIPE - - - - - - - - - -
		
		getEquipes_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du membre: ");
				co.sql("call getEquipes_candidat("+id+")");
			}
		});
		
		getMembres_squad.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de l'équipe: ");
				co.sql("call getMembres_squad("+id+")");
			}
		});
		
		addEquipe_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de l'équipe: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call addEquipe_candidat("+id_c+","+id+")");
			}
		});
		
		removeEquipe_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de l'équipe: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				co.sql("call removeEquipe_candidat("+id_c+","+id+")");
			}
		});
		
		// - - - - - - - - - - PATÉ LUNAIRE INSCRIRE - - - - - - - - - -
		
		getCandidats_insc.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call getCandidats_insc("+id+")");
			}
		});
		
		desinsc_candid.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call desinsc_candid("+id_c+","+id+")");
			}
		});
		
		addCompet_candidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				int id = utilitaires.EntreesSorties.getInt("ID du candidat: ");
				int id_c = utilitaires.EntreesSorties.getInt("ID de la compétition: ");
				co.sql("call addCompet_candidat("+id+","+id_c+")");
			}
		});
		
	menuIndex.start();
	}	
}
