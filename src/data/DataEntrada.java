package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public LinkedList<Entrada> buscarEntrada (Entrada buscaEntrada) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		LinkedList<Entrada> entradas = new LinkedList<Entrada>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni from entrada where dni=? and fecha_hora_funcion >= current_date()");
			stmt.setString(1, buscaEntrada.getDni());
			
			rs = stmt.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					Entrada ent = new Entrada();
					ent.setNumero_butaca(rs.getInt("numero_butaca"));
					ent.setNro_sala(rs.getInt("nro_sala"));
					ent.setCod_pelicula(rs.getInt("cod_pelicula"));
					ent.setFecha_hora_funcion(rs.getObject("fecha_hora_funcion", LocalDateTime.class));
					ent.setTotal(rs.getDouble("total"));
					ent.setDni(rs.getString("dni"));
					entradas.add(ent);
				}
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
		
		return entradas;
	}
	
	public void borrarEntrada(Entrada borraEnt) {
		
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from entrada where dni = ?");
			stmt.setString(1, borraEnt.getDni());
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
