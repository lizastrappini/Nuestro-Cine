package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Calificacion;



public class DataCalificacion {
	
	public void cargarCalificacion(Calificacion nuevaCalificacion) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into calificacion"
					+ "(descripcion values (?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nuevaCalificacion.getDescripcion());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()) {
				nuevaCalificacion.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close(); }
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public LinkedList<Calificacion>listarCalificacion(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Calificacion>calificaciones= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select idCalificacion, descripcion from calificacion");
			if (rs !=null) {
				while (rs.next()) {
					Calificacion c = new Calificacion();
					c.setId(rs.getInt("idCalificacion"));
					c.setDescripcion(rs.getString("descripcion"));
					calificaciones.add(c);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return calificaciones;
	}
	
	public Calificacion buscarCalificacion (Calificacion c) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Calificacion cal = null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idCalificacion, descripcion from calificacion WHERE LOWER(descripcion) = LOWER(?)  "
					);
			
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getDescripcion());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				cal = new Calificacion();
				cal.setId(rs.getInt("idGenero"));
				cal.setDescripcion(rs.getString("descripcion"));
				
			}
			
		}  catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		
		return cal;
		
	}
	
	public void modificar(Calificacion c) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update calificacion "
					+ "set descripcion=? where idCalificacion=?");
		
			stmt.setString(1, c.getDescripcion());
			stmt.setInt(2, c.getId());
			stmt.executeUpdate();	
		} catch (SQLException e) {
			
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void borrarCalificacion(Calificacion c) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from calificacion where idCalificacion = ?");
			stmt.setInt(1, c.getId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
