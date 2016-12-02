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
	
	@Test	// Avoir le nom d'une compétition
	public void testGetNom() {
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", null, true);
		assertEquals(competition.getNom(),"Mondial d'épluchage de patate");
	}

	@Test	// Changer le nom d'une compétition
	public void testSetNom() {
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", null, true);
		competition.setNom("Mondial de lancer de carotte");
		assertEquals(competition.getNom(),"Mondial de lancer de carotte");
	}

	@Test	// Tester si une compétition est ouverte
	public void testInscriptionsOuvertes() {
		LocalDate date1 = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date1, true);
		assertTrue(competition.inscriptionsOuvertes());
	}

	@Test	// Avoir la date de cloture d'une compétition
	public void testGetDateCloture() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date, true);
		assertEquals(competition.getDateCloture(),date);
	}

	@Test
	public void testEstEnEquipe() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date, true);
		assertTrue(competition.estEnEquipe());
	}

	@Test
	public void testSetDateCloture() {
		LocalDate date = LocalDate.now();
		Competition compet = new Competition(i, "Mondial d'épluchage de patate", date, true);
		compet.setDateCloture(date);
		assertEquals(compet.getDateCloture(), date);
	}

	@Test
	public void testGetCandidats() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date, false);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		competition.add(tony);
		assertEquals(candidats,competition.getCandidats());
	}

	@Test
	public void testAddPersonne() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date, false);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		competition.add(tony);
		candidats.add(tony);
		assertEquals(candidats,competition.getCandidats());
	}

	@Test
	public void testAddEquipe() {
		LocalDate date = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date, true);
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		Equipe meme = new Equipe(i, "Memelords");
		meme.add(tony);
		competition.add(meme);
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
