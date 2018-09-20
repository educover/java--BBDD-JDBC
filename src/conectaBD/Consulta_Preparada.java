package conectaBD;

import java.sql.*;

public class Consulta_Preparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//1. CREAR CONEXION
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			
			//2. PREPARAR CONSULTA
			PreparedStatement miSentencia = miConexion.prepareStatement("SELECT * FROM clientes WHERE POBLACIÓN=?");
			
			//3. ESTABLECER PARAMETROS DE CONSULTA
			miSentencia.setString(1, "SEVILLA");
			
			//4. EJECUTAR Y RECORRER CONSULTA
			ResultSet rs = miSentencia.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("EMPRESA") + " " + rs.getString("POBLACIÓN"));
			}
			
			rs.close();
			
			//5. REUTILIZANDO CONSULTA SQL
			
			System.out.println("EJECUCION SEGUNDA CONSULTA");
			System.out.println("");
			
			
			miSentencia.setString(1, "BARCELONA");
			
			
			rs = miSentencia.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("EMPRESA") + " " + rs.getString("POBLACIÓN"));
			}
			
			rs.close();
			
		}catch(Exception e){
			
		}

	}

}
