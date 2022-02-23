package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Genero;
import entities.Pelicula;

public class DataGenero {
	
	public void cargarGenero(Genero nuevoGenero) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into genero"
					+ "(descripcion) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nuevoGenero.getDescripcion());
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()) {
				nuevoGenero.setId(rs.getInt(1));
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
	
	public LinkedList<Genero>listarGeneros(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Genero>generos= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select idGenero, descripcion from genero");
			if (rs !=null) {
				while (rs.next()) {
					Genero g = new Genero();
					g.setId(rs.getInt("idGenero"));
					g.setDescripcion(rs.getString("descripcion"));
					generos.add(g);
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
		return generos;
	}
	
	
	public Genero buscarGenero (Genero g) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Genero gen = null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idGenero, descripcion from genero WHERE LOWER(descripcion) = LOWER(?)  "
					);
			
			
			stmt.setString(1, g.getDescripcion());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				gen = new Genero();
				gen.setId(rs.getInt("idGenero"));
				gen.setDescripcion(rs.getString("descripcion"));
				
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
		
		return gen;
		
	}
	
	public void modificar(Genero g) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update genero "
					+ "set descripcion=? where idGenero=?");
		
			stmt.setString(1, g.getDescripcion());
			stmt.setInt(2, g.getId());
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
	
	public void borrarGenero(Genero g) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from genero where idGenero = ?");
			stmt.setInt(1, g.getId());
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
