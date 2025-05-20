package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clase.Profesor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {

	private Connection conexion;

	
	
	public ProfesorDAO() {
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/institutodb", "root", "sqldofe65");
		} catch (SQLException e) {
			System.out.println("Error al crear la conexión con la base de datos: " + e.getMessage());
		}
		
	}

	public Connection getConexion() {
		return conexion;
	}
	
	public void crearProfe(Profesor prof) {
		
		String sql = "INSERT INTO estudiantes (nombre, apellido, especialidad, email)"
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = conexion.prepareStatement(sql);
			ps.setString(1, prof.getNombre());
			ps.setString(2, prof.getApellido());
			ps.setString(3, prof.getEspecialidad());
			ps.setString(4, prof.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error al insertar el profesor: " + e.getMessage());
		}
	}

	
	public ArrayList<Profesor> mostrarProfe() {
		
			ArrayList<Profesor> lista = new ArrayList<Profesor>();
			
			String sql = "select * from profesores";
			
			try {
				PreparedStatement ps = conexion.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);
				
				while(rs.next()) {
					Profesor nuevo = new Profesor(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3));
					lista.add(nuevo);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return lista;
	}
	

	public void buscarProfe() {
		
	}

	public void actualizarProfe() {
		
	}

	public void eliminarProfe() {
		
	}

}
