package tests;


import static org.junit.Assert.*;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestInscriptions {

	private SortedSet<Competition> competitions = new TreeSet<>();
	private SortedSet<Candidat> candidats = new TreeSet<>();
	private SortedSet<Equipe> testequipe = new TreeSet<>();
	private SortedSet<Competition> vide = new TreeSet<>();
	private Inscriptions i  = Inscriptions.getInscriptions();
	
	@Before
	public void initialiser() throws Exception {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		candidats.add(tony);
	}
	
	@After
	public void nettoyer() throws Exception {
	  competitions = null;
	  candidats = null;
	  testequipe = null;
	  vide = null;
	  i.reinitialiser();
	}
	
	@Test	// Avoir la liste des comp�titions
	public void testGetCompetitions() {
		
		assertEquals(competitions,i.getCompetitions());
	}

	@Test
	public void testGetCandidats() {
		assertEquals(candidats,i.getCandidats());
	}

	@Test	// R�cup�rer une personne
	public void testGetPersonnes() {
		assertEquals(candidats,i.getPersonnes());
	}

	@Test	// R�cup�rer les �quipes
	public void testGetEquipes() {
		
		assertEquals(testequipe,i.getEquipes());
	}

	@Test
	public void testCreateCompetition() {	// Cr�er une comp�tition
		assertEquals(competitions,i.getCompetitions());
	}

	@Test	// Cr�er une personne
	public void testCreatePersonne() {
		assertEquals(candidats,i.getPersonnes());
	}

	@Test	// Cr�er une �quipe
	public void testCreateEquipe() {
		assertEquals(testequipe,i.getEquipes());
	}

	@Test
	public void testRemoveCompetition() {
		assertEquals(vide,i.getCompetitions());
	}

	@Test
	public void testRemoveCandidat() {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		candidats.remove(tony);
		assertEquals(vide,candidats);
	}

	@Test
	public void testGetInscriptions() {
		assertEquals(i,i.getInscriptions());
	}

	@Test
	public void testReinitialiser() {
		Inscriptions i = new Inscriptions();
		assertNotNull(i);
	}

	@Test
	public void testRecharger() {
		Inscriptions i  = null;
		assertNull(i);
	}

}