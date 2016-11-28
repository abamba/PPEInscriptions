package tests;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

public class TestInscriptions {

	@Test
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

	@Test
	public void testGetPersonnes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEquipes() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateCompetition() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreatePersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEquipe() {
		fail("Not yet implemented");
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
