package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.Entrada;

public class DataEntrada {
	
	public void cargarEntrada(Entrada nuevaEntrada) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"insert into entrada (numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni) values (?, ?, ?, ?, ?, ?)");
			
			stmt.setInt(1, nuevaEntrada.getNumero_butaca());
			stmt.setInt(2, nuevaEntrada.getNro_sala());
			stmt.setInt(3, nuevaEntrada.getCod_pelicula());
			stmt.setObject(4, nuevaEntrada.getFecha_hora_funcion());
			stmt.setDouble(5, nuevaEntrada.getTotal());
			stmt.setString(6, nuevaEntrada.getDni());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null ) {rs.close();}
				if(stmt !=null ) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e ) {
				e.printStackTrace();
			}
		}
	}

	public LinkedList<Entrada>listarEntradas(){
		Statement stmt= null;
		ResultSet rs=null;
		LinkedList<Entrada>entradas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni from entrada");
			if (rs != null ) {
				while (rs.next()) {
					Entrada e = new Entrada();
					e.(rs.getInt("codigo_calificacion"));
					c.setDescripcion(rs.getString("descripcion"));
					calificaciones.add(c);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null ) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return calificaciones;
	}*/
	public Entrada buscarEntrada (Entrada buscaEntrada) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Entrada ent = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni from entrada where dni=?");
			stmt.setString(1, buscaEntrada.getDni());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				ent = new Entrada();
				ent.setNumero_butaca(rs.getInt("numero_butaca"));
				ent.setNro_sala(rs.getInt("nro_sala"));
				ent.setCod_pelicula(rs.getInt("cod_pelicula"));
				ent.setFecha_hora_funcion(rs.getObject("fecha_hora", LocalDateTime.class));
				ent.setTotal(rs.getDouble("total"));
				ent.setDni(rs.getString("dni"));
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
		
		return ent;
	}
	/*public void modificar(Calificacion cali) {
		PreparedStatement stmt =null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"update calificacion set codigo_calificacion=?, descripcion=? where codigo_calificacion=?");
			
			stmt.setInt(1, cali.getCodigo_calificacion());
			stmt.setString(2, cali.getDescripcion());
			stmt.setInt(3, cali.getCodigo_calificacion());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
		} finally {
			try {
				if (stmt!= null) {stmt.close();}

				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void borrarCalificacion(Calificacion borraCali) {
		
		PreparedStatement stmt=null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"delete from calificacion where codigo_calificacion=?");
			stmt.setInt(1, borraCali.getCodigo_calificacion());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null ) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Calificacion buscarPorCodigo(Integer codigo) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Calificacion cali = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo_calificacion, descripcion from calificacion where codigo_calificacion = ?");
			stmt.setInt(1, codigo);
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				cali = new Calificacion();
				cali.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
				cali.setDescripcion(rs.getString("descripcion"));
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
		return cali;
	}*/

}
