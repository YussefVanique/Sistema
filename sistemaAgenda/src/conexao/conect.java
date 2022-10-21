package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conect {
	public static Connection createConnectionToMySQL() throws SQLException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","yussef2125");
		return conn;
				
	}catch (ClassNotFoundException e){
		throw new SQLException(e.getException());
	}
		
	}
	
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Connection conn = createConnectionToMySQL();
	if(conn!=null) {
		System.out.println("conectado!!!");
		conn.close();
	}
}
}



/*package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conect{
	
public static Connection getConnection;

public static void main (String[] args) {
	String usuario = "root";
	String senha = "yussef2125";
    String url= ("jdbc:mysql://localhost:3306/agenda") ;
  
    try{
    	Connection connection = DriverManager.getConnection(url, usuario, senha);
    	System.out.println("Conectado com sucesso");
       	connection.close();

      }catch(Exception ex){
       ex.printStackTrace();
       System.err.println("Erro ao conectar com o BD: \n" + ex);
	        
      }
	}

}*/ 
