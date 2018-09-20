package Practica_Guiada1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Aplicacion mimarco = new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}


class Marco_Aplicacion extends JFrame{
	public Marco_Aplicacion(){
		setTitle("Consulta BBDD");
		setBounds(500, 300, 400, 400);
		setLayout(new BorderLayout());
		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		
		paises = new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		
		resultado = new JTextArea(4, 50);
		resultado.setEditable(false);
		add(resultado);
		
		menus.add(secciones);
		menus.add(paises);
		
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta = new JButton("Consulta");
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
			
		});
		add(botonConsulta, BorderLayout.SOUTH);
		
		//----------------CONEXION CON BBDD-------------------------//
		try{
			//1. CREAR CONEXION
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			//2. CREAR OBJETO STATEMENT
			Statement sentencia = miConexion.createStatement();
			
			String consulta = "SELECT POBLACIÓN FROM CLIENTES";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next()){
				secciones.addItem(rs.getString(1));
			}
			rs.close();
			
			consulta = "SELECT RESPONSABLE FROM CLIENTES";
			
			rs = sentencia.executeQuery(consulta);
			
			while(rs.next()){
				paises.addItem(rs.getString(1));
			}
			rs.close();
		}catch(Exception e){
			
		}
	}
	
	private void ejecutaConsulta(){
		ResultSet rs=null;
		try{
			String seccion=(String) secciones.getSelectedItem();
			enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
			enviaConsultaSeccion.setString(1, seccion);
			rs = enviaConsultaSeccion.executeQuery();
			while(rs.next()){
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append(", ");
				resultado.append(rs.getString(5));
				resultado.append(", ");
				resultado.append(rs.getString(6));
				
				resultado.append("\n");
			}
		}catch(Exception e){
			
		}
		System.out.println(resultado.getLineCount());

	}
	private Connection miConexion;
	private PreparedStatement enviaConsultaSeccion;
	private final String consultaSeccion = "SELECT EMPRESA, DIRECCIÓN, POBLACIÓN, RESPONSABLE FROM clientes WHERE POBLACIÓN=?";
	private JComboBox secciones, paises;
	private JTextArea resultado;
}