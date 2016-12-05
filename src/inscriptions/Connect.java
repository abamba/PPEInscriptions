package inscriptions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

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
}
