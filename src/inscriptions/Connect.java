package inscriptions;

import java.sql.Connection;
import java.sql.DriverManager;

//CTRL + SHIFT + O pour g�n�rer les imports
public class Connect {
  public static void main(String[] args) {      
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver O.K.");

      String url = "jdbc:mysql://localhost:3306/inscription";
      String user = "root";
      String passwd = "";

      Connection conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");         
         
    } catch (Exception e) {
      e.printStackTrace();
    }      
  }
}