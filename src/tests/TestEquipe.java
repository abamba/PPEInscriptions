package tests;

import static org.junit.Assert.*;
import inscriptions.Candidat;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEquipe {

	private SortedSet<Candidat> vide = new TreeSet<>();
	private Inscriptions i  = Inscriptions.getInscriptions();
	private Equipe e = new Equipe(i, "Clan des Semi-Croustillants");
	
	@Before
	public void initialiser() throws Exception {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		e.remove(tony);
	}
	
	@After
	public void nettoyer() throws Exception {
	  i.reinitialiser();
	}
	
	@Test
	public void testDelete() {
		e.delete();
		assertEquals(i.getEquipes(),vide);
	}

	@Test
	public void testGetMembres() {
		assertEquals(e.getMembres(),vide);
	}

	@Test
	public void testRemovePersonne() {
		Personne tony = i.createPersonne("Tony", "Dent de plomb", "azerty");
		e.add(tony);
		e.remove(tony);
		assertEquals(e.getMembres(),vide);
	}

}
