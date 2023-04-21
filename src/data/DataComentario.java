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

}
