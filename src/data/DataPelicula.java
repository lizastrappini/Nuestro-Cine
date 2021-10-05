package data;

import java.sql.*;
import java.util.LinkedList;



import entities.Pelicula;

public class DataPelicula {

		public void cargarPelicula(Pelicula nuevaPeli) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into pelicula"
					+ "(nombre, director, genero, calificacion, duracion, sinopsis, portada) values (?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nuevaPeli.getNombre());
			stmt.setString(2, nuevaPeli.getDirector());
			stmt.setString(3, nuevaPeli.getGenero());
			stmt.setString(4, nuevaPeli.getCalificacion());
			stmt.setDouble(5, nuevaPeli.getDuracion());
			stmt.setString(6, nuevaPeli.getSinopsis());
			//stmt.setBlob(7, nuevaPeli.getFoto_Usu());
			stmt.setBlob(7, nuevaPeli.getFoto_Usu());
			
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()) {
				nuevaPeli.setCodigo(rs.getInt(1));
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

	public LinkedList<Pelicula>listarPeliculas(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select codigo, nombre, director, genero,calificacion, duracion, sinopsis, portada from pelicula");
			if (rs !=null) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setGenero(rs.getString("genero"));
					p.setCalificacion(rs.getString("calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					//p.setRecuperar_Foto_Usu(rs.getBytes("Portada"));
					p.setRecuperar_Foto_Usu(rs.getBytes("portada"));
					
					peliculas.add(p);
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
		return peliculas;
	}
	public Pelicula buscarPelicula (Pelicula buscaPeli) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Pelicula peli = null;
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from pelicula where codigo = ?");
			stmt.setInt(1, buscaPeli.getCodigo());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				peli = new Pelicula();
				peli.setCodigo(rs.getInt("codigo"));
				peli.setNombre(rs.getString("nombre"));
				peli.setDirector(rs.getString("director"));
				peli.setGenero(rs.getString("genero"));
				peli.setCalificacion(rs.getString("calificacion"));
				peli.setDuracion(rs.getDouble("duracion"));
				peli.setSinopsis(rs.getString("sinopsis"));
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
		return peli;
	}

	public void modificar(Pelicula peli) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update pelicula "
					+ "set nombre=?, director=?, genero=?, calificacion=?, duracion=?, sinopsis=? where codigo=?");
		
			stmt.setString(1, peli.getNombre());
			stmt.setString(2, peli.getDirector());
			stmt.setString(3, peli.getGenero());
			stmt.setString(4, peli.getCalificacion());
			stmt.setDouble(5, peli.getDuracion());
			stmt.setString(6, peli.getSinopsis());
			stmt.setInt(7, peli.getCodigo());
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
	public void borrarPelicula(Pelicula borraPeli) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from pelicula where codigo = ?");
			stmt.setInt(1, borraPeli.getCodigo());
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
