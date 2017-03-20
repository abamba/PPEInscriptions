package inscriptions;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Représente une personne physique pouvant s'inscrire à une compétition.
 */

public class Personne extends Candidat
{
	private static final long serialVersionUID = 4434646724271327254L;
	private String prenom, mail;
	private Set<Equipe> equipes;
	Connect co = new Connect();
	Personne(Inscriptions inscriptions, String nom, String prenom, String mail)
	{
		super(inscriptions, nom);
		this.prenom = prenom;
		this.mail = mail;
		equipes = new TreeSet<>();
	}

	/**
	 * Retourne le prénom de la personne.
	 * @return
	 */
	
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Modifie le prénom de la personne.
	 * @param prenom
	 */
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne l'adresse électronique de la personne.
	 * @return
	 */
	
	public String getMail()
	{
		return mail;
	}

	/**
	 * Modifie l'adresse électronique de la personne.
	 * @param mail
	 */
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retourne les équipes dont cette personne fait partie.
	 * @return
	 */
	
	public Set<Equipe> getEquipes()
	{
		return Collections.unmodifiableSet(equipes);
	}
	
	boolean add(Equipe equipe)
	{
		return equipes.add(equipe);
	}

	boolean remove(Equipe equipe)
	{
		return equipes.remove(equipe);
	}
	
	@Override
	public void delete()
	{
		super.delete();
		for (Equipe e : equipes)
			e.remove(this);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " membre de " + equipes.toString();
	}
	
	// Custom
	
	/**
	 * Avoir la liste des personnes composant une équipe
	 * @param id_squad
	 */
	
	public void getListeComp(int id_squad)
	{
		co.sql("call getCompet_candidat("+id_squad+")");
	}
	
	/**
	 * Inscrire un candidat à une compétition
	 * @param id_comp
	 * @param id_squad
	 */
	
	public void inscComp(int id_comp,int id_squad)
	{
		co.sql("call addCompet_candidat("+id_comp+","+id_squad+")");
	}
	
	/**
	 * Désinscrire un candidat d'une compétition
	 * @param id_comp
	 * @param id_squad
	 */
	
	public void desinscComp(int id_comp,int id_squad)
	{
		co.sql("call desinsc_candid("+id_comp+","+id_squad+")");
	}
	
	/**
	 * Modifier le nom d'une équipe
	 * @param id_squad
	 * @param nom
	 */
	
	public void modNom(int id_squad, String nom)
	{
		co.sql("call setNom_candidat("+id_squad+","+nom+")");
	}
	
	/**
	 * Supprime une équipe
	 * @param id_squad
	 */
	
	public void suppPersonne(int id_squad)
	{
		co.sql("call del_candidat("+id_squad+")");
	}
}
