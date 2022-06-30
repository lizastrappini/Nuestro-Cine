package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.Comentario;
import entities.Pelicula;

public class DataComentario {
	
	public void cargarComentario(Comentario nuevoComentario) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"insert into comentario (comentario, dni, codigo_pel, fecha_hora) values (?,?,?,?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nuevoComentario.getComentario());
			stmt.setString(2, nuevoComentario.getDni());
			stmt.setInt(3, nuevoComentario.getCodigo_pel());
			stmt.setObject(4, nuevoComentario.getFecha_hora());
			
			stmt.executeUpdate();
			
			rs= stmt.getGeneratedKeys();
			
			if(rs!= null && rs.next()) {
				nuevoComentario.setId_comentario(rs.getInt(1));
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
	
	/*public LinkedList<Comentario>listarComentarios(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Comentario>comentarios= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select codigo_pelicula, fecha_hora, numero_sala from funcion");
			if (rs !=null) {
				while (rs.next()) {
					Funcion f = new Funcion();
					f.setCodigo_pelicula(rs.getInt("codigo_pelicula"));
					f.setFecha_hora(rs.getObject("fecha_hora", LocalDateTime.class));
					f.setNumero_sala(rs.getInt("numero_sala"));
					funciones.add(f);
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
		return funciones;
	}*/
	public LinkedList<Comentario> buscarComentarioPorPeli (Comentario buscaCom) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Comentario>comentarios_peli= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from comentario where codigo_pel=? order by fecha_hora desc;");
			stmt.setInt(1, buscaCom.getCodigo_pel());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
				Comentario com = new Comentario();
				com.setId_comentario(rs.getInt("id_comentario"));
				com.setComentario(rs.getString("comentario"));
				com.setDni(rs.getString("dni"));
				com.setCodigo_pel(rs.getInt("codigo_pel"));
				com.setFecha_hora(rs.getObject("fecha_hora", LocalDateTime.class));
				
				comentarios_peli.add(com);
				}
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
		return comentarios_peli;
	}
	
	
	public LinkedList<Comentario> listarComentarios (Pelicula pel) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Comentario>comentarios_peli= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from comentario where codigo_pel=? order by fecha_hora desc;");
			stmt.setInt(1, pel.getCodigo());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
				Comentario com = new Comentario();
				com.setId_comentario(rs.getInt("id_comentario"));
				com.setComentario(rs.getString("comentario"));
				com.setDni(rs.getString("dni"));
				com.setCodigo_pel(rs.getInt("codigo_pel"));
				com.setFecha_hora(rs.getObject("fecha_hora", LocalDateTime.class));
				
				comentarios_peli.add(com);
				}
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
		return comentarios_peli;
	}
	/*public Funcion buscarFuncion (Funcion buscaFuncion) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Funcion fun = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select * from funcion where codigo_pelicula = ? and numero_sala = ? and fecha_hora = ?");
			stmt.setInt(1, buscaFuncion.getCodigo_pelicula());
			stmt.setInt(2, buscaFuncion.getNumero_sala());
			stmt.setObject(3, buscaFuncion.getFecha_hora());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				fun = new Funcion();
				fun.setCodigo_pelicula(rs.getInt("codigo_pelicula"));
				fun.setNumero_sala(rs.getInt("numero_sala"));
				fun.setFecha_hora(rs.getObject("fecha_hora", LocalDateTime.class));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!= null ) {rs.close();}
				if(stmt != null ) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fun;
	}*/

	
	/*public void modificarFuncion(Funcion funcionNueva, Funcion funcionAnterior) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"update funcion set codigo_pelicula=?, fecha_hora=?, numero_sala=? where codigo_pelicula=? and fecha_hora=? and numero_sala=?");
		
			stmt.setInt(1, funcionNueva.getCodigo_pelicula());
			stmt.setObject(2, funcionNueva.getFecha_hora());
			stmt.setInt(3, funcionNueva.getNumero_sala());
			stmt.setInt(4, funcionAnterior.getCodigo_pelicula());
			stmt.setObject(5, funcionAnterior.getFecha_hora());
			stmt.setInt(6, funcionAnterior.getNumero_sala());
			
			stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null ) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}*/
	
	/*public void borrarFuncion(Funcion borraFun) {
		PreparedStatement stmt=null;
		
		try {
			ButacaFuncion borraBut = new ButacaFuncion();
			
			borraBut.setCod_pelicula(borraFun.getCodigo_pelicula());
			borraBut.setFecha_hora_funcion(borraFun.getFecha_hora());
			borraBut.setNro_sala(borraFun.getNumero_sala());
			
			DataButacaFuncion dbf = new DataButacaFuncion();
			dbf.borrarButaca(borraBut);
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from funcion where codigo_pelicula=? and fecha_hora=? and numero_sala=?");
			stmt.setInt(1, borraFun.getCodigo_pelicula());
			stmt.setObject(2, borraFun.getFecha_hora());
			stmt.setInt(3, borraFun.getNumero_sala());
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
	}*/
	
	/*public void borrarFuncionesPorSala(Sala borraSala) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from funcion where numero_sala=?");
			stmt.setInt(1, borraSala.getNumero());
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
	}*/
	/*public void borrarFuncionesDePelicula(Pelicula pel) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from funcion where codigo_pelicula=?");
			stmt.setInt(1, pel.getCodigo());
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
	}*/

}
