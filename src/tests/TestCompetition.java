package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.Test;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import org.junit.After;
import org.junit.Before;

public class TestCompetition {
	private SortedSet<Candidat> candidats = new TreeSet<>();
	private SortedSet<Candidat> vide = new TreeSet<>();
	private Inscriptions i  = Inscriptions.getInscriptions();
	
	@Before
	public void initialiser() throws Exception {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		candidats.add(tony);
	}
	
	@After
	public void nettoyer() throws Exception {
	  candidats = null;
	  i.reinitialiser();
	}
	
	@Test	// Avoir le nom d'une comp�tition
	public void testGetNom() {
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		assertEquals(competition.getNom(),"Mondial d'�pluchage de patate");
	}

	@Test	// Changer le nom d'une comp�tition
	public void testSetNom() {
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		competition.setNom("Mondial de lancer de carotte");
		assertEquals(competition.getNom(),"Mondial de lancer de carotte");
	}

	@Test	// Tester si une comp�tition est ouverte
	public void testInscriptionsOuvertes() {
		LocalDate date1 = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date1, true);
		assertTrue(competition.inscriptionsOuvertes());
	}

	@Test	// Avoir la date de cloture d'une comp�tition
	public void testGetDateCloture() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, true);
		assertEquals(competition.getDateCloture(),date);
	}

	@Test
	public void testEstEnEquipe() {	// Tester si la comp�tition est en �quipe ou pas
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, true);
		assertTrue(competition.estEnEquipe());
	}

	@Test
	public void testSetDateCloture() {	// Mettre une date de cloture
		LocalDate date = LocalDate.now();
		Competition compet = new Competition(i, "Mondial d'�pluchage de patate", date, true);
		compet.setDateCloture(date);
		assertEquals(compet.getDateCloture(), date);
	}

	@Test
	public void testGetCandidats() {	// Avoir la liste des candidats d'une comp�tition
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, false);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		competition.add(tony);
		assertEquals(candidats,competition.getCandidats());
	}

	@Test
	public void testAddPersonne() {	// Ajouter une personne � une comp�tition
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, false);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		competition.add(tony);
		candidats.add(tony);
		assertEquals(candidats,competition.getCandidats());
	}

	@Test
	public void testAddEquipe() {	// Ajouter une �quipe � une comp�tition
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, true);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		Equipe meme = new Equipe(i, "Memelords");
		meme.add(tony);
		competition.add(meme);
		assertEquals(meme,meme);
	}

	@Test
	public void testRemove() {	// D�sinscrit un candidat
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", date, true);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		Equipe meme = new Equipe(i, "Memelords");
		meme.add(tony);
		competition.add(meme);
		competition.remove(meme);
		assertEquals(competition.getCandidats(),vide);
	}

	@Test
	public void testDelete() {	// Supprime une comp�tition de l'application
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		competition.delete();
		assertEquals(i.getCompetitions(),vide);
	}

	@Test
	public void testCompareTo() {	// Renvoie un entier correspondant � la diff�rence de lettres entre les deux noms
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		Competition competition2 = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		assertEquals(competition.compareTo(competition2),0);
	}

	@Test
	public void testToString() {	// Renvoie le nom de la comp�tition sous forme d'une chaine
		Competition competition = new Competition(i, "Mondial d'�pluchage de patate", null, true);
		assertEquals(competition.toString(),"Mondial d'�pluchage de patate");
	}

}
