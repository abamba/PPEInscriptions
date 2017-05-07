package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import persistance.Connect;

/**
 * Candidat à un événement sportif, soit une personne physique, soit une équipe.
 */

public class Candidat implements Comparable<Candidat>, Serializable
{
	private static final long serialVersionUID = -6035399822298694746L;
	private Inscriptions inscriptions;
	private String nom;
	private String prenom;
	private String mail;
	private Boolean sub; 
	static Connect co = Inscriptions.getInscriptions().getConnect();
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
		co.modPers(this);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		co.modPers(this);
	}

	private Set<Competition> competitions;
	private int id = -1;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (this.id == -1)
			this.id = id;
		else
			throw new RuntimeException();
	}

	public Candidat(Inscriptions inscriptions, String nom)
	{
		this.inscriptions = inscriptions;	
		this.nom = nom;
		competitions = new TreeSet<>();
	}

	public Boolean getSub() {
		return sub;
	}

	public void setSub(Boolean sub) {
		this.sub = sub;
		co.modPers(this);
	}

	/**
	 * Retourne le nom du candidat.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du candidat.
	 * @param nom
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
		co.modPers(this);
	}

	/**
	 * Retourne toutes les compétitions auxquelles ce candidat est inscrit.
	 * @return
	 */

	public Set<Competition> getCompetitions()
	{
		competitions.clear();
		competitions.addAll(co.getListeComp(this));
		return Collections.unmodifiableSet(competitions);
	}
	
	public Set<Competition> getNonCompetitions()
	{
		return Collections.unmodifiableSet(co.getListeNonComp(this));
	}
	
	boolean add(Competition competition)
	{
		co.inscComp(this, competition);
		return competitions.add(competition);
	}

	boolean remove(Competition competition)
	{
		co.desinscComp(competition, this);
		return competitions.remove(competition);
	}

	/**
	 * Supprime un candidat de l'application.
	 */
	
	public void delete()
	{
		for (Competition c : competitions)
			c.remove(this);
		co.delCandidat(this);
		inscriptions.remove(this);
	}
	
	@Override
	public int compareTo(Candidat o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return "\n" + getNom() + " -> inscrit à " + getCompetitions();
	}
}
