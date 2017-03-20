package menus;

import inscriptions.Inscriptions;
import java.util.Scanner;
import java.util.Set;

import inscriptions.Candidat;
import inscriptions.Connect;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class MenuCompetition {
	int comp = -1;
	public void ajoutmenu()
	{
		Inscriptions insc = Inscriptions.getInscriptions();
		Connect co = new Connect();
		Menu inscriptions = new Menu("Menu Competition", "3");
		
		// INSCRIPTIONS
		Option listeCandidat = new Option("Liste des candidats", "1");
		Option inscrireCandidat = new Option("Inscrire un candidat", "2");
		Option supprCandidat = new Option("Supprimer un candidat", "3");
		Option modNom = new Option("Liste des candidats", "4");
		Option modDate = new Option("Inscrire un candidat", "5");
		Option modType = new Option("Inscrire un candidat", "6");
		Option supprComp = new Option("Supprimer un candidat", "7");
		
		inscriptions.ajoute(listeCandidat);
		inscriptions.ajoute(inscrireCandidat);
		inscriptions.ajoute(supprCandidat);
		inscriptions.ajoute(modNom);
		inscriptions.ajoute(modDate);
		inscriptions.ajoute(modType);
		inscriptions.ajoute(supprComp);
		inscriptions.ajouteRevenir("r");
		
		// - - - - - - - - - - PATÉ LUNAIRE INSCRIRE - - - - - - - - - -
		
		listeCandidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				insc.getCompetitions();
		}
		});
		
		inscrireCandidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		supprCandidat.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		modNom.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		modDate.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		modType.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		
		supprComp.setAction(new Action()
		{
			public void optionSelectionnee() {
				System.out.println(insc.getCompetitions());
			}
		});
		MenuIndex menu = new MenuIndex();
		menu.menuAdd(inscriptions);
	}

}
