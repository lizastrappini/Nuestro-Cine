package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import entities.Pelicula;

public class DataPelicula {

		public void cargarPelicula(Pelicula nuevaPeli) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String nombre = nuevaPeli.getNombre().toUpperCase(); //para guardar los nombres en mayuscula
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"insert into pelicula (nombre, director, id_genero, codigo_calificacion, duracion, sinopsis, portada, fecha_estreno) values (?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nombre);
			stmt.setString(2, nuevaPeli.getDirector());
			stmt.setInt(3, nuevaPeli.getId_genero());
			stmt.setInt(4, nuevaPeli.getCodigo_calificacion());
			stmt.setDouble(5, nuevaPeli.getDuracion());
			stmt.setString(6, nuevaPeli.getSinopsis());
			stmt.setString(7, nuevaPeli.getPortada());
			stmt.setObject(8, nuevaPeli.getFecha_estreno());
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
			rs= stmt.executeQuery(
					"Select codigo, nombre, director, id_genero, codigo_calificacion, duracion, sinopsis, portada from pelicula");
			if (rs !=null) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					
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
	public Pelicula buscarPelicula (Pelicula p) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Pelicula peli = null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo,nombre,director,id_genero,codigo_calificacion,duracion,sinopsis from pelicula WHERE UPPER(nombre) = UPPER(?) and UPPER(director) = UPPER(?) "
					);
			
			stmt.setString(1, p.getNombre());
			stmt.setString(1, p.getDirector());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				peli = new Pelicula();
				peli.setCodigo(rs.getInt("codigo"));
				peli.setNombre(rs.getString("nombre"));
				peli.setDirector(rs.getString("director"));
				peli.setId_genero(rs.getInt("id_genero"));
				peli.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
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
					+ "set nombre=?, director=?, id_genero=?, codigo_calificacion=?, duracion=?, sinopsis=?, fecha_estreno=?, portada=? where codigo=?");
		
			stmt.setString(1, peli.getNombre());
			stmt.setString(2, peli.getDirector());
			stmt.setInt(3, peli.getId_genero());
			stmt.setInt(4, peli.getCodigo_calificacion());
			stmt.setDouble(5, peli.getDuracion());
			stmt.setString(6, peli.getSinopsis());
			stmt.setObject(7, peli.getFecha_estreno());
			stmt.setString(8, peli.getPortada());
			stmt.setInt(9, peli.getCodigo());

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
		DataFuncion df = new DataFuncion();
		DataButacaFuncion bf = new DataButacaFuncion();
		
		bf.borrarButacasPorPelicula(borraPeli);
		df.borrarFuncionesDePelicula(borraPeli);
		
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from pelicula where codigo = ?");
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
	
	public LinkedList<Pelicula> buscarPorGenero (Integer codigo) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo, nombre, director, id_genero, codigo_calificacion, duracion, sinopsis, portada from pelicula where id_genero=?");   
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					
					
					peliculas.add(p);
				}}
			
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
		return peliculas; 
	}
	
	public LinkedList<Pelicula> buscarPorEdad (Integer edad) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo, nombre, director, id_genero, codigo_calificacion, duracion, sinopsis, portada from pelicula where codigo_calificacion=?");   
			stmt.setInt(1, edad);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					
					
					peliculas.add(p);
				}}
			
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
		return peliculas; 
	}
	
	public LinkedList<Pelicula> listarEstrenos () {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select  codigo, nombre, sinopsis, director, duracion, portada, fecha_estreno, id_genero, codigo_calificacion from pelicula where (month(fecha_estreno) = month(current_date()) and year(fecha_estreno) = year(current_date())) ");   
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					
					
					peliculas.add(p);
				}}
			
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
		return peliculas; 
	}
	
	
	public Pelicula buscarPorCodigo (Integer cod) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Pelicula p= new Pelicula();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo, nombre, director, id_genero, codigo_calificacion, duracion, sinopsis, portada, fecha_estreno from pelicula where codigo = ? ");   
			stmt.setInt(1, cod);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					p.setFecha_estreno(rs.getObject("fecha_estreno", LocalDate.class));
			
				}}
			
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
		return p; 
	}
	
	
	public LinkedList<Pelicula> buscarPorNombre (String nombre) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT codigo, nombre, sinopsis, director, duracion, portada, fecha_estreno, id_genero, codigo_calificacion FROM pelicula WHERE nombre like UPPER(concat('%',concat(?,'%'))) or nombre like LOWER(concat('%',concat(?,'%'))) ");   
			stmt.setString(1, nombre);
			stmt.setString(2, nombre);
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setId_genero(rs.getInt("id_genero"));
					p.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					
					peliculas.add(p);
					
				}}
			
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
		return peliculas; 
	}	
}
