package controlador;
import java.sql.*;

public class Conexion {
	
	Connection miConexion=null;
	public Conexion(){
		
	}
	
	public Connection dameConexion(){
		try{
			//1. CREAR CONEXION
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
		} catch(Exception e){
			
		}
		
		return miConexion;
	}
}
