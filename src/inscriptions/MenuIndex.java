package inscriptions;

import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuIndex {

	static void Index()
	{
	Menu menuIndex = new Menu("Index");
	
	Menu candidat = new Menu("Menu Candidat", "1");
	Menu competition = new Menu("Menu Compétition", "2");
	Menu equipe = new Menu("Menu Equipe", "3");
	Menu personne = new Menu("Menu Personne", "4");

	menuIndex.ajoute(candidat);
	menuIndex.ajoute(competition);
	menuIndex.ajoute(equipe);
	menuIndex.ajoute(personne);
	
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

	menuIndex.start();
	}	
}
