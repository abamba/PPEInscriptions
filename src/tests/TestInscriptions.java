package tests;


import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestInscriptions {

	@Test	// Avoir la liste des compétitions
	public void testGetCompetitions() {
		SortedSet<Competition> competitions = new TreeSet<>();
		Inscriptions i  = Inscriptions.getInscriptions();
		Competition flechettes = i.createCompetition("Mondial de fléchettes", null, false);
		competitions.add(flechettes);
		assertEquals(competitions,i.getCompetitions());
	}

	@Test
	public void testGetCandidats() {
		fail("Not yet implemented");
	}

	@Test	// Récupérer une personne
	public void testGetPersonnes() {
		SortedSet<Personne> testpersonnes = new TreeSet<>();
		Inscriptions i = new Inscriptions();
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		testpersonnes.add(tony);
		assertEquals(testpersonnes,i.getPersonnes());
	}

	@Test	// Récupérer les équipes
	public void testGetEquipes() {
		SortedSet<Equipe> testequipe = new TreeSet<>();
		Inscriptions i = new Inscriptions();
		Equipe lesManouches = i.createEquipe("Les Manouches");
		testequipe.add(lesManouches);
		assertEquals(testequipe,i.getEquipes());
	}

	@Test
	public void testCreateCompetition() {
		fail("Not yet implemented");
	}

	@Test	// Créer une personne
	public void testCreatePersonne() {
		SortedSet<Personne> testpersonnes = new TreeSet<>();
		Inscriptions i = new Inscriptions();
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		testpersonnes.add(tony);
		assertEquals(testpersonnes,i.getPersonnes());
	}

	@Test	// Créer une équipe
	public void testCreateEquipe() {
		SortedSet<Equipe> testequipe = new TreeSet<>();
		Inscriptions i = new Inscriptions();
		Equipe lesManouches = i.createEquipe("Test");
		testequipe.add(lesManouches);
		assertEquals(testequipe,i.getEquipes());
	}

	@Test
	public void testRemoveCompetition() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCandidat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInscriptions() {
		fail("Not yet implemented");
	}

	@Test
	public void testReinitialiser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecharger() {
		fail("Not yet implemented");
	}

	@Test
	public void testSauvegarder() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}