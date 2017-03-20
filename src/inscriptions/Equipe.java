package inscriptions;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Représente une Equipe. C'est-Ã -dire un ensemble de personnes pouvant 
 * s'inscrire Ã  une compétition.
 * 
 */

public class Equipe extends Candidat
{
	Connect co = new Connect();
	private static final long serialVersionUID = 4147819927233466035L;
	private SortedSet<Personne> membres = new TreeSet<>();
	
	public Equipe(Inscriptions inscriptions, String nom)
	{
		super(inscriptions, nom);
	}

	/**
	 * Retourne l'ensemble des personnes formant l'équipe.
	 */
	
	public SortedSet<Personne> getMembres()
	{
		return Collections.unmodifiableSortedSet(membres);
	}
	
	/**
	 * Ajoute une personne dans l'équipe.
	 * @param membre
	 * @return
	 */

	public boolean add(Personne membre)
	{
		membre.add(this);
		return membres.add(membre);
	}

	/**
	 * Supprime une personne de l'équipe. 
	 * @param membre
	 * @return
	 */
	
	public boolean remove(Personne membre)
	{
		membre.remove(this);
		return membres.remove(membre);
	}

	@Override
	public void delete()
	{
		super.delete();
	}
	
	@Override
	public String toString()
	{
		return "Equipe " + super.toString();
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
		co.sql("call getCompet_candidat("+id_comp+","+id_squad+")");
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
		co.sql("call getCompet_candidat("+id_squad+","+nom+")");
	}
	
	/**
	 * Supprime une équipe
	 * @param id_squad
	 */
	
	public void suppEquipe(int id_squad)
	{
		co.sql("call del_candidat("+id_squad+")");
	}
}
