package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
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
	
	@Test
	public void testGetNom() {
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", null, true);
		assertEquals(competition.getNom(),"Mondial d'épluchage de patate");
	}

	@Test
	public void testSetNom() {
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", null, true);
		competition.setNom("Mondial de lancer de carotte");
		assertEquals(competition.getNom(),"Mondial de lancer de carotte");
	}

	@Test
	public void testInscriptionsOuvertes() {
		LocalDate date1 = LocalDate.now();
		Competition competition = new Competition(i, "Mondial d'épluchage de patate", date1, true);
		assertTrue(competition.inscriptionsOuvertes());
	}

	@Test
	public void testGetDateCloture() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstEnEquipe() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDateCloture() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCandidats() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEquipe() {
		fail("Not yet implemented");
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
