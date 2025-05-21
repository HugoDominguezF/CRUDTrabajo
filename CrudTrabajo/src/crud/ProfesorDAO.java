package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import clase.Profesor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfesorDAO {

	private Connection conexion;

	public ProfesorDAO() {

		try {

			String url = "jdbc:mysql://localhost/institutodb";
			String usuario = "root";
			String contraseña = "sqldofe65";
			this.conexion = DriverManager.getConnection(url, usuario, contraseña);

		} catch (SQLException e) {
			System.out.println("Error al crear la conexión con la base de datos: " + e.getMessage());
		}

	}

	public Connection getConexion() {
		return conexion;
	}

	public void crearProfe(Profesor prof) {

		String sql = "INSERT INTO profesores (nombre, apellido, especialidad, email)" + "VALUES (?, ?, ?, ?)";

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

		String sql = "SELECT * FROM profesores";

		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				Profesor nuevo = new Profesor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				lista.add(nuevo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Profesor buscarProfe(int id) {

		String sql = "SELECT * FROM profesores where id_profesor = ?";

		Profesor nuevo = null;

		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				nuevo = new Profesor(id,rs.getString("nombre"),rs.getString("apellido"),rs.getString("especialidad"),rs.getString("email"));
			}

		} catch (SQLException e) {
			System.out.println("Error al buscar el profesor: " + e.getMessage());
		}

		return nuevo;
	}

	public boolean actualizarProfe(String cambiar, String nuevo, int id) {
		
		String sql = "UPDATE profesores SET " + cambiar + " = ? WHERE id_profesor = ?";
		
		boolean funciona=true;

		try {
		    PreparedStatement ps = conexion.prepareStatement(sql);

		    ps.setString(1, nuevo);
		    ps.setInt(2, id);

		    ps.executeUpdate();

		} catch (SQLException e) {
		    System.out.println("Error al actualizar el profesor: " + e.getMessage());
		    funciona = false;
		}
		return funciona;
		
	}

	public boolean eliminarProfe(int id) {
		String sql = "delete FROM profesores where id_profesor = ?";

		boolean funciona=true;
		
		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al buscar el profesor: " + e.getMessage());
			funciona = false;
		}
		return funciona;
	}

}
