package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import persistance.Connect;

/**
 * Représente une compétition, c'est-à-dire un ensemble de candidats 
 * inscrits à un événement, les inscriptions sont closes à la date dateCloture.
 *
 */

public class Competition implements Comparable<Competition>, Serializable
{
	private static final long serialVersionUID = -2882150118573759729L;
	private Inscriptions inscriptions;
	private String nom;
	private Set<Candidat> candidats;
	private LocalDate dateCloture;
	private boolean enEquipe = false;
	private int id = -1; 
	static Connect co = Inscriptions.getInscriptions().getConnect();
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		if (this.id == -1)
			this.id = id;
		else
			throw new RuntimeException();
	}

	public Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		this.inscriptions = inscriptions;
		this.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	/**
	 * Retourne le nom de la compétition.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom de la compétition.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom ;
		co.modComp(this);
	}
	
	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes, 
	 * faux si les inscriptions sont closes.
	 * @return
	 */
	
	public boolean inscriptionsOuvertes()
	{
		boolean ans = false;
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = this.getDateCloture();
		if(date1.compareTo(date2)>=0){	// Si la date du jour est plus grande (et donc non dépassée) par la date de cloture
			ans = true;
		}
		return ans;
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */
	
	public LocalDate getDateCloture()
	{
		return dateCloture;
	}
	
	/**
	 * Est vrai si et seulement si les inscriptions sont réservées aux équipes.
	 * @return
	 */
	
	public boolean estEnEquipe()
	{
		return enEquipe;
	}
	
	/**
	 * Modifie le statut équipe de la compétition
	 * @param enEquipe
	 */
	
	public void setEnEquipe(Boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		co.modComp(this);
	}
	
	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer 
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */
	
	public void setDateCloture(LocalDate dateCloture)
	{
		if(this.dateCloture==null)
			this.dateCloture = dateCloture;
		else	// Si la date du jour est plus grande (et donc non dépassée) par la date de cloture
			if(dateCloture.compareTo(this.dateCloture)>0)
				this.dateCloture = dateCloture;
	}
	
	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */
	
	public Set<Candidat> getCandidats()
	{
		candidats.clear();
		candidats.addAll(co.getlisteCandidat(this));
		return Collections.unmodifiableSet(candidats);
	}
	
	/**
	 * Retourne l'ensemble des candidats non inscrits.
	 * @return
	 */
	
	public Set<Candidat> getNonInscrits()
	{
		return Collections.unmodifiableSet(co.getNonInscrits(this));
	}
	
	/**
	 * Inscrit un candidat à la compétition. Provoque une
	 * exception si la compétition est réservée aux équipes ou que les 
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */
	
	public boolean add(Candidat cand)
	{
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = dateCloture;
		// Si la date du jour est avant par la date de cloture
		if(date1.isBefore(date2)||date1.isEqual(date2))
			if (!enEquipe && !cand.getSub())
				cand.add(this);
			else if (enEquipe && cand.getSub()) 
				cand.add(this);
		co.inscrireCandidat(cand, this);
		return candidats.add(cand);
	}

	/**
	 * Désinscrit un candidat.
	 * @param candidat
	 * @return
	 */
	
	public boolean remove(Candidat candidat)
	{
		candidat.remove(this);
		co.desinscComp(this, candidat);
		return candidats.remove(candidat);
	}
	
	/**
	 * Supprime la compétition de l'application.
	 */
	
	public void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		co.supprComp(this);
		inscriptions.remove(this);
	}
	
	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return getNom();
	}
	
	// Custom
	
}