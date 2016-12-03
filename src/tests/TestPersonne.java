package tests;

import static org.junit.Assert.*;
import inscriptions.Candidat;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPersonne {

	private SortedSet<Candidat> vide = new TreeSet<>();
	private Inscriptions i  = Inscriptions.getInscriptions();
	private Personne tony;
	
	@Before
	public void initialiser() throws Exception {
		i = Inscriptions.getInscriptions();
		tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
	}
	
	@After
	public void nettoyer() throws Exception {
	  i.reinitialiser();
	}
	
	@Test
	public void testDelete() {	// Supprimer une personne
		tony.delete();
		assertEquals(i.getCandidats(),vide);
	}

	@Test
	public void testGetPrenom() {	// Avoir le prénom d'une personne
		assertEquals(tony.getPrenom(),"Dent de plomb");
	}

	@Test
	public void testSetPrenom() {	// Changer le prénom d'une personne
		tony.setPrenom("Jacques");
		assertEquals(tony.getPrenom(),"Jacques");
	}

	@Test
	public void testGetMail() {	// Avoir le mail d'une personne
		assertEquals(tony.getMail(),"azerty");
	}

	@Test
	public void testSetMail() {	// Changer le mail d'une personne
		tony.setMail("qwerty");
		assertEquals(tony.getMail(),"qwerty");
	}

	@Test
	public void testGetEquipes() {	// Avoir les équipes d'une personne
		assertEquals(tony.getEquipes(),vide);
	}
}
