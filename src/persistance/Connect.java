package persistance;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

import inscriptions.Candidat;
import inscriptions.Competition;

public class Connect {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/inscription";
	static final String USER = "root";
	static final String PASS = "";
	
	public Connect() {
		try {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Driver O.K.");
	
		      String url = DB_URL;
		      String user = USER;
		      String passwd = PASS;
	
		      @SuppressWarnings("unused")
			Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");         
		         
		} catch (Exception e) {
		      e.printStackTrace();
		}      
	}
	
	public static void sql(String requete) {

		String url = DB_URL;
		String login = USER;
		String pass = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, login, pass);
			st = (Statement) cn.createStatement();
			String sql = requete;
			rs = st.executeQuery(sql);
			
			ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
			int columncount = metadata.getColumnCount();
			for (int i = 1; i <= columncount; i++) {
				System.out.println(metadata.getColumnName(i) + ", ");
			}
			System.out.println();
			while (rs.next()) {
		        String row = "";
		        for (int i = 1; i <= columncount; i++) {
		            row += rs.getString(i) + ", ";          
		        }
		        System.out.println();
		        System.out.println(row);
			}
			System.out.println();
		}
		catch (SQLException e) {
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			}
			catch (SQLException e){
				e.printStackTrace();;
			}
		}
	}
	
	/**
	 * Retourne la liste des candidats de la compétition id_comp
	 * @param comp
	 */

	public void listeCandidat(Competition comp)
	{
		sql("call ListeCandidat("+comp.getId()+")");
	}
	
	/**
	 * Inscrit le candidat à la compétition 
	 * @param comp
	 * @param cand
	 */
	
	public void inscrireCandidat(Candidat cand, Competition comp)
	{
		sql("call inscrireCandidat("+cand.getId()+","+comp.getId()+")");
	}
	
	/**
	 * Supprime le candidat de la compétition 
	 * @param comp
	 * @param cand
	 */
	
	public void supprCandidat(Competition comp, Candidat cand)
	{
		sql("call supprCandidat("+comp.getId()+","+cand.getId()+")");
	}
	
	/**
	 * Supprimer une compétition
	 * @param comp
	 */
	
	public void supprComp(Competition comp)
	{
		sql("call del_compet("+comp.getId()+")");
	}

	/**
	 * Modifier une compétition
	 * @param comp
	 */
	
	public void modComp(Competition comp)
	{
		sql("call modComp("+comp.getId()+", "+comp.getNom()+", "+comp.getDateCloture()+", "+comp.estEnEquipe()+")");
	}
	
	/**
	 * Créer une compétition
	 * @param comp
	 */
	
	public static void createComp(Competition comp)
	{
		sql("call createComp("+comp.getNom()+","+comp.getDateCloture()+","+comp.estEnEquipe()+")");
	}
	
	/**
	 * Créer un candidat de type personne
	 * @param cand
	 */
	
	public void createPers(Candidat cand)
	{
		sql("call createPers("+cand.getNom()+","+cand.getPrenom()+","+cand.getMail()+")");
	}
	
	/**
	 * Créer un candidat de type équipe
	 * @param cand
	 */
	
	public void createEq(Candidat cand)
	{
		sql("call createEq("+cand.getNom()+","+cand.getPrenom()+","+cand.getMail()+")");
	}
	
	/**
	 * Afficher les compétitions 
	 */
	
	public void afficheComp()
	{
		sql("call afficheComp()");
	}
	
	/**
	 * Afficher les personnes
	 */
	
	public void affichePers()
	{
		sql("call affichePers()");
	}
	
	/**
	 * Afficher les équipes
	 */
	
	public void afficheEq()
	{
		sql("call afficheEq()");
	}
	
	/**
	 * Avoir la liste des personnes composant une équipe
	 * @param id_squad
	 */
	
	public void getListeComp(int id_squad)
	{
		sql("call getCompet_candidat("+id_squad+")");
	}
	
	/**
	 * Inscrire un candidat à une compétition
	 * @param id_comp
	 * @param id_squad
	 */
	
	public void inscComp(int id_comp,int id_squad)
	{
		sql("call getCompet_candidat("+id_comp+","+id_squad+")");
	}
	
	/**
	 * Désinscrire un candidat d'une compétition
	 * @param id_comp
	 * @param id_squad
	 */
	
	public void desinscComp(int id_comp,int id_squad)
	{
		sql("call desinsc_candid("+id_comp+","+id_squad+")");
	}
	
	/**
	 * Modifier le nom d'une équipe
	 * @param id_squad
	 * @param nom
	 */
	
	public void modNom(int id_squad, String nom)
	{
		sql("call getCompet_candidat("+id_squad+","+nom+")");
	}
	
	/**
	 * Supprime une équipe
	 * @param id_squad
	 */
	
	public void suppEquipe(int id_squad)
	{
		sql("call del_candidat("+id_squad+")");
	}
}
