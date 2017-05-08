package persistance;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;

public class Connect {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/inscription?useSSL=false";
	static final String USER = "root";
	static final String PASS = "";
	
	public Connect() {
		try {
		      Class.forName("com.mysql.jdbc.Driver");
	
		      String url = DB_URL;
		      String user = USER;
		      String passwd = PASS;
	
		      @SuppressWarnings("unused")
		      Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
		         
		} catch (Exception e) {
		      e.printStackTrace();
		}      
	}
	
	public void sql(String requete) {

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
			String row = "";
			int columncount = metadata.getColumnCount();
			for (int i = 1; i <= columncount; i++) {
				row += metadata.getColumnName(i) + " | ";  
			}
	        System.out.println(row);
			while (rs.next()) {
		        row = "";
		        for (int i = 1; i <= columncount; i++) {
		            row += rs.getString(i) + ", ";          
		        }
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
	 * Retourner la liste des compétitions et les stocker dans des variables
	 */
	
	public SortedSet<Candidat> getCand()
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Candidat> candidats = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "call afficheCand()";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(3));
		        candidat.setId(rs.getInt(2)); 
		        if (rs.getBoolean(5)) 
		        {
		        	candidat.setPrenom(null);
		        }else{
		        	candidat.setPrenom(rs.getString(4));
		        }
		        candidat.setSub(rs.getBoolean(5));
		        candidat.setMail(rs.getString(6));
				candidats.add(candidat);
			}
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
		return candidats;
	}
	
	public SortedSet<Competition> getComp()
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Competition> competitions = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "call afficheComp()";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Competition competition = new Competition(Inscriptions.getInscriptions(), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getBoolean(5));
		        competition.setId(rs.getInt(2));
				competitions.add(competition);
			}
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
		return competitions;
	}
	
	public SortedSet<Competition> getListeComp(Candidat cand)
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Competition> competitions = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "call getListeComp("+cand.getId()+")";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Competition competition = new Competition(Inscriptions.getInscriptions(), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getBoolean(5));
		        competition.setId(rs.getInt(2));
				competitions.add(competition);
			}
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
		return competitions;
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
	 * Retourne la liste des candidats de la compétition id_comp
	 * @param comp
	 * @return 
	 */
	
	public SortedSet<Candidat> getNonInscrits(Competition comp)
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Candidat> candidats = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "call getNonInscrits("+comp.getId()+")";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(2));
		        candidat.setId(rs.getInt(1)); 
		        if (rs.getBoolean(3)) 
		        {
		        	candidat.setPrenom(null);
		        }else{
		        	candidat.setPrenom(rs.getString(4));
		        }
		        candidat.setSub(rs.getBoolean(3));
		        candidat.setMail(rs.getString(5));
				candidats.add(candidat);
			}
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
		return candidats;
	}
	
	/**
	 * Liste des participants à une compétition
	 * @param comp
	 * @return
	 */
	
	public SortedSet<Candidat> getlisteCandidat(Competition comp)
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Candidat> candidats = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "call ListeCandidat("+comp.getId()+")";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(2));
		        candidat.setId(rs.getInt(1)); 
		        if (rs.getBoolean(3)) 
		        {
		        	candidat.setPrenom(null);
		        }else{
		        	candidat.setPrenom(rs.getString(4));
		        }
		        candidat.setSub(rs.getBoolean(3));
		        candidat.setMail(rs.getString(5));
				candidats.add(candidat);
			}
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
		return candidats;
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
		sql("call modComp("+comp.getId()+", \""+comp.getNom()+"\",\""+comp.getDateCloture()+"\", "+comp.estEnEquipe()+")");
	}
	
	/**
	 * Créer une compétition
	 * @param comp
	 */
	
	public void createComp(Competition comp)
	{
		sql("call createComp(\""+comp.getNom()+"\",\""+comp.getDateCloture()+"\","+comp.estEnEquipe()+")");
	}
	
	/**
	 * Créer un candidat
	 * @param cand
	 */
	
	public void createPers(Candidat cand)
	{
		if(cand.getSub())
		{
			sql("call createPers(\""+cand.getNom()+"\","+cand.getSub()+",null,\""+cand.getMail()+"\")");
		}
		else
		{
			sql("call createPers(\""+cand.getNom()+"\","+cand.getSub()+",\""+cand.getPrenom()+"\",\""+cand.getMail()+"\")");
		}
	}
	
	/**
	 * Afficher les candidats
	 */
	
	public void afficheCand() 
	{
		sql("call afficheCand()");
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
	 * Liste des compétitions où est inscrit le candidat
	 * @param cand
	 */
	
	public void ListeComp(Candidat cand)
	{
		sql("call ListeComp("+cand.getId()+")");
	}
	
	/**
	 * Inscrire un candidat à une compétition
	 * @param cand
	 * @param comp
	 */ 
	
	public void inscComp(Candidat cand, Competition comp)
	{
		sql("call inscComp("+cand.getId()+","+comp.getId()+")");
	}
	
	/**
	 * Désinscrire un candidat d'une compétition
	 * @param comp
	 * @param cand
	 */
	
	public void desinscComp(Competition comp, Candidat cand)
	{
		sql("call desinscComp("+comp.getId()+","+cand.getId()+")");
	}
	
	/**
	 * Modifier un candidat
	 * @param cand
	 */
	
	public void modPers(Candidat cand)
    {
        sql("call modPers("+cand.getId()+", \""+cand.getPrenom()+"\",\""+cand.getNom()+"\",\""+cand.getMail()+"\")");
    }
	
	/**
	 * Supprime un candidat
	 * @param cand
	 */
	
	public void delCandidat(Candidat cand)
	{
		sql("call delCandidat("+cand.getId()+")");
	}
	
	/**
	 * Membres d'une équipe
	 * @param cand
	 */
	
	public SortedSet<Candidat> Composition(Candidat cand)
	{
			String url = DB_URL;
			String log = USER;
			String pw = PASS;
			Connection cn = null; Statement st = null; ResultSet rs = null; 
			SortedSet<Candidat> candidats = new TreeSet<>(); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = (Connection) DriverManager.getConnection(url, log, pw);
				st = (Statement) cn.createStatement();
				String sql = "call Composition("+cand.getId()+")";
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(2));
			        candidat.setId(rs.getInt(1)); 
			        if (rs.getBoolean(3)) 
			        {
			        	candidat.setPrenom(null);
			        }else{
			        	candidat.setPrenom(rs.getString(4));
			        }
			        candidat.setSub(rs.getBoolean(3));
			        candidat.setMail(rs.getString(5));
					candidats.add(candidat);
				}
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
			return candidats;
	}
	
	/**
	 * Les équipes d'un membre
	 * @param cand
	 * @return
	 */
	
	public SortedSet<Candidat> CompositionEquipe(Candidat cand)
	{
			String url = DB_URL;
			String log = USER;
			String pw = PASS;
			Connection cn = null; Statement st = null; ResultSet rs = null; 
			SortedSet<Candidat> candidats = new TreeSet<>(); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = (Connection) DriverManager.getConnection(url, log, pw);
				st = (Statement) cn.createStatement();
				String sql = "call CompositionEquipe("+cand.getId()+")";
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(2));
			        candidat.setId(rs.getInt(1)); 
			        if (rs.getBoolean(3)) 
			        {
			        	candidat.setPrenom(null);
			        }else{
			        	candidat.setPrenom(rs.getString(4));
			        }
			        candidat.setSub(rs.getBoolean(3));
			        candidat.setMail(rs.getString(5));
					candidats.add(candidat);
				}
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
			return candidats;
	}
	
	/**
	 * Liste des compétitions auxquelles un membre n'est PAS inscrit
	 * @param cand
	 * @return
	 */
	
	public SortedSet<Competition> getListeNonComp(Candidat cand)
	{
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Competition> competitions = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "SELECT * FROM Competition WHERE COMPETITION.enEquipe = "+cand.getSub()+" AND COMPETITION.id_compet NOT IN (SELECT INSCRIRE.id_compet FROM Inscrire WHERE id_candidat = "+cand.getId()+");";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Competition competition = new Competition(Inscriptions.getInscriptions(), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getBoolean(4));
		        competition.setId(rs.getInt(1));
				competitions.add(competition);
			}
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
		return competitions;
	}

	/**
	 * Enlève un candidat d'une équipe
	 * @param cand
	 * @param eq
	 */
	public void Decompose(Candidat cand,Candidat eq)
	{
		sql("call Decompose("+cand.getId()+","+eq.getId()+")");
	}

	public SortedSet<Candidat> NonComposition(Candidat cand) {
		String url = DB_URL;
		String log = USER;
		String pw = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null; 
		SortedSet<Candidat> candidats = new TreeSet<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, log, pw);
			st = (Statement) cn.createStatement();
			String sql = "SELECT * FROM Candidat WHERE sub = false AND id_candidat NOT IN (SELECT id_candidat_pers FROM Composer WHERE id_candidat_squad = "+cand.getId()+");";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Candidat candidat = new Candidat(Inscriptions.getInscriptions(), rs.getString(2));
		        candidat.setId(rs.getInt(1)); 
		        if (rs.getBoolean(3)) 
		        {
		        	candidat.setPrenom(null);
		        }else{
		        	candidat.setPrenom(rs.getString(4));
		        }
		        candidat.setSub(rs.getBoolean(3));
		        candidat.setMail(rs.getString(5));
				candidats.add(candidat);
			}
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
		return candidats;
	}

	public void Compose(Candidat squad, Candidat cand) {
		sql("call Compose("+cand.getId()+","+squad.getId()+")");
	}

}
