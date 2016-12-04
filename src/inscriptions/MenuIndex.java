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
	
	menuIndex.start();
	}
}
