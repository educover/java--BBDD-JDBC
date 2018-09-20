package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Modifica_BBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			
			//2.Crear objeto Statement
			Statement miStatement = miConexion.createStatement();
			
			String instruccionSql="INSERT INTO CLIENTES(CÓDIGOCLIENTE, EMPRESA, RESPONSABLE) VALUES ('CT27', 'INTERCONTROL', 'PEDRO ALCOVER')";
			
			miStatement.executeUpdate(instruccionSql);
			
			System.out.println("Datos insertados correctamente");
		}catch(Exception e){
			System.out.println("No conecta");
			e.printStackTrace();
		}
		
	}

}
