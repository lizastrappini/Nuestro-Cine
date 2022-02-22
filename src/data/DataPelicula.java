package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Pelicula;

public class DataPelicula {

		public void cargarPelicula(Pelicula nuevaPeli) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		String nombre = nuevaPeli.getNombre().toUpperCase(); //para guardar los nombres en mayuscula
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into pelicula"
					+ "(nombre, director, genero, calificacion, duracion, sinopsis, portada, fecha_estreno) values (?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nombre);
			stmt.setString(2, nuevaPeli.getDirector());
			stmt.setString(3, nuevaPeli.getGenero());
			stmt.setString(4, nuevaPeli.getCalificacion());
			stmt.setDouble(5, nuevaPeli.getDuracion());
			stmt.setString(6, nuevaPeli.getSinopsis());
			stmt.setString(7, nuevaPeli.getPortada());
			java.sql.Date date = nuevaPeli.convertirFecha(nuevaPeli.getFecha_estreno());			
			stmt.setDate(8, date);
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
			rs= stmt.executeQuery("Select p.codigo, p.nombre, p.director, g.descripcion,c.descripcion, p.duracion, p.sinopsis, p.portada\r\n"
					+ "from pelicula p inner join genero g on p.genero = g.idGenero\r\n"
					+ "inner join calificacion c on p.calificacion = c.idCalificacion");
			if (rs !=null) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("p.codigo"));
					p.setNombre(rs.getString("p.nombre"));
					p.setDirector(rs.getString("p.director"));
					p.setGenero(rs.getString("g.descripcion"));
					p.setCalificacion(rs.getString("c.descripcion"));
					p.setDuracion(rs.getDouble("p.duracion"));
					p.setSinopsis(rs.getString("p.sinopsis"));
					p.setPortada(rs.getString("p.portada"));
					
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
					"select codigo,nombre,director,genero,calificacion,duracion,sinopsis from pelicula WHERE UPPER(nombre) = UPPER(?) and UPPER(director) = UPPER(?) "
					);
			
			stmt.setString(1, p.getNombre());
			stmt.setString(1, p.getDirector());
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
					+ "set nombre=?, director=?, genero=?, calificacion=?, duracion=?, sinopsis=?, fecha_estreno=? where codigo=?");
		
			stmt.setString(1, peli.getNombre());
			stmt.setString(2, peli.getDirector());
			stmt.setString(3, peli.getGenero());
			stmt.setString(4, peli.getCalificacion());
			stmt.setDouble(5, peli.getDuracion());
			stmt.setString(6, peli.getSinopsis());
			java.sql.Date date = peli.convertirFecha(peli.getFecha_estreno());
			stmt.setDate(7, date);
			stmt.setInt(8, peli.getCodigo());
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
	
	public LinkedList<Pelicula> buscarPorGenero (String genero) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(""
					+ "select p.codigo,p.nombre,p.sinopsis, p.director, p.duracion, p.portada, p.fecha_estreno, g.descripcion, c.descripcion\r\n"
					+ "from pelicula p inner join genero g on p.genero=g.idGenero and LOWER(g.descripcion)=LOWER(?)\n"
					+ "inner join calificacion c on p.calificacion=c.idCalificacion");   
			stmt.setString(1, genero);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("p.codigo"));
					p.setNombre(rs.getString("p.nombre"));
					p.setDirector(rs.getString("p.director"));
					p.setGenero(rs.getString("g.descripcion"));
					p.setCalificacion(rs.getString("c.descripcion"));
					p.setDuracion(rs.getDouble("p.duracion"));
					p.setSinopsis(rs.getString("p.sinopsis"));
					p.setPortada(rs.getString("p.portada"));
					
					
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
	
	public LinkedList<Pelicula> buscarPorEdad (String edad) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Pelicula>peliculas= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement(""
					+ "select p.codigo,p.nombre,p.sinopsis,p.director,p.duracion, p.portada, p.fecha_estreno,c.descripcion, g.descripcion\n"
					+ "from pelicula p inner join calificacion c on p.calificacion=c.idcalificacion and LOWER(c.descripcion) = LOWER(?) \n"
					+ "inner join genero g on p.genero=g.idGenero ");   
			stmt.setString(1, edad);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("p.codigo"));
					p.setNombre(rs.getString("p.nombre"));
					p.setDirector(rs.getString("p.director"));
					p.setGenero(rs.getString("g.descripcion"));
					p.setCalificacion(rs.getString("c.descripcion"));
					p.setDuracion(rs.getDouble("p.duracion"));
					p.setSinopsis(rs.getString("p.sinopsis"));
					p.setPortada(rs.getString("p.portada"));
					
					
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
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select  p.codigo,p.nombre,p.sinopsis, p.director, p.duracion, p.portada, p.fecha_estreno, g.descripcion, c.descripcion from pelicula p\r\n"
					+ "inner join genero g on g.idGenero=p.genero\r\n"
					+ "inner join calificacion c on c.idcalificacion=p.calificacion\r\n"
					+ "where month(fecha_estreno) = month(current_date())) ");   
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("p.codigo"));
					p.setNombre(rs.getString("p.nombre"));
					p.setDirector(rs.getString("p.director"));
					p.setGenero(rs.getString("g.descripcion"));
					p.setCalificacion(rs.getString("p.descripcion"));
					p.setDuracion(rs.getDouble("p.duracion"));
					p.setSinopsis(rs.getString("p.sinopsis"));
					p.setPortada(rs.getString("p.portada"));
					
					
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
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from pelicula where codigo = ? ");   
			stmt.setInt(1, cod);
			
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					
					p.setCodigo(rs.getInt("codigo"));
					p.setNombre(rs.getString("nombre"));
					p.setDirector(rs.getString("director"));
					p.setGenero(rs.getString("genero"));
					p.setCalificacion(rs.getString("calificacion"));
					p.setDuracion(rs.getDouble("duracion"));
					p.setSinopsis(rs.getString("sinopsis"));
					p.setPortada(rs.getString("portada"));
					p.setFecha_estreno(rs.getObject("fecha_estreno",Date.class));
			
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
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT p.codigo,p.nombre, p.sinopsis, p.director, p.duracion, p.portada, p.fecha_estreno, g.descripcion, c.descripcion FROM pelicula p\r\n"
					+ "inner join genero g on p.genero = g.idGenero\r\n"
					+ "inner join calificacion c on p.calificacion = c.idCalificacion\r\n"
					+ "WHERE nombre like UPPER(concat('%',concat(?,'%'))) or nombre like LOWER(concat('%',concat(?,'%'))) ");   
			stmt.setString(1, nombre);
			stmt.setString(2, nombre);
			rs = stmt.executeQuery();
			
			if(rs!=null ) {
				while (rs.next()) {
					Pelicula p = new Pelicula();
					p.setCodigo(rs.getInt("p.codigo"));
					p.setNombre(rs.getString("p.nombre"));
					p.setDirector(rs.getString("p.director"));
					p.setGenero(rs.getString("g.descripcion"));
					p.setCalificacion(rs.getString("c.descripcion"));
					p.setDuracion(rs.getDouble("p.duracion"));
					p.setSinopsis(rs.getString("p.sinopsis"));
					p.setPortada(rs.getString("p.portada"));
					
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
