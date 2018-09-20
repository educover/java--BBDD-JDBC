package conectaBD;

import java.sql.*;

public class conecta_pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//1. Crear conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			
			//2.Crear objeto Statement
			Statement miStatement = miConexion.createStatement();
			
			//3. Ejecutar sentencia SQL
			ResultSet miResultado = miStatement.executeQuery("select * from clientes where POBLACIÓN = 'BARCELONA'");
			
			//4. Leer el resultset
			while(miResultado.next()){
				System.out.println(miResultado.getString("EMPRESA") + " " + miResultado.getString("POBLACIÓN"));
			}
		}catch(Exception e){
			System.out.println("No conecta");
			e.printStackTrace();
		}
		
	}

}
