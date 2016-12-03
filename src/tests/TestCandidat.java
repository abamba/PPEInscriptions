package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import inscriptions.Candidat;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCandidat {

	private SortedSet<Candidat> candidats = new TreeSet<>();
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
	  candidats = null;
	  i.reinitialiser();
	}

	@Test
	public void testGetNom() {	// Avoir le nom d'un candidat
		candidats.add(tony);
		candidats.first().setNom("Coucou");
		assertEquals(candidats.first().getNom(),"Coucou");
	}

	@Test
	public void testSetNom() {	// Mettre le nom d'un candidat
		candidats.add(tony);
		candidats.first().setNom("Coucou");
		assertEquals(candidats.first().getNom(),"Coucou");
	}

	@Test
	public void testGetCompetitions() {	// Avoir la liste des compétitions auxquelles un candidat participe
		candidats.add(tony);
		assertEquals(candidats.first().getCompetitions(),vide);
	}

	@Test
	public void testCompareTo() {	// Renvoie la différence de taille entre deux noms de candidats
		candidats.add(tony);
		assertEquals(candidats.first().compareTo(candidats.first()),0);
	}

}