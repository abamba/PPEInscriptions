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
	
	@Test	// Avoir la liste des compétitions
	public void testGetCompetitions() {
		
		assertEquals(competitions,i.getCompetitions());
	}

	@Test	// Avoir la liste des candidats
	public void testGetCandidats() {
		assertEquals(candidats,i.getCandidats());
	}

	@Test	// Récupérer une personne
	public void testGetPersonnes() {
		assertEquals(candidats,i.getPersonnes());
	}

	@Test	// Récupérer les équipes
	public void testGetEquipes() {
		
		assertEquals(testequipe,i.getEquipes());
	}

	@Test	// Créer une compétition
	public void testCreateCompetition() {
		assertEquals(competitions,i.getCompetitions());
	}

	@Test	// Créer une personne
	public void testCreatePersonne() {
		assertEquals(candidats,i.getPersonnes());
	}

	@Test	// Créer une équipe
	public void testCreateEquipe() {
		assertEquals(testequipe,i.getEquipes());
	}

	@Test	// Enlever les compétitions
	public void testRemoveCompetition() {
		assertEquals(vide,i.getCompetitions());
	}

	@Test	// Enlever un candidat
	public void testRemoveCandidat() {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		candidats.remove(tony);
		assertEquals(vide,candidats);
	}

	@Test	// Avoir la liste des inscriptions
	public void testGetInscriptions() {
		assertEquals(i,i.getInscriptions());
	}

	@Test	// Réinitialiser la une inscription
	public void testReinitialiser() {
		Inscriptions i = new Inscriptions();
		assertNotNull(i);
	}

	@Test	// Remettre à zéro une inscription
	public void testRecharger() {
		Inscriptions i  = null;
		assertNull(i);
	}

}