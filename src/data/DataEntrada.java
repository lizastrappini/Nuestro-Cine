package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import entities.Entrada;
import entities.Funcion;
import entities.ButacaFuncion;

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
					"select id_entrada, numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni from entrada where dni=? and fecha_hora_funcion >= current_date()");
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
					ent.setId_entrada(rs.getInt("id_entrada"));
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
	
	public Entrada buscarEntradaPorId (Integer id) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Entrada ent = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select numero_butaca, nro_sala, cod_pelicula, fecha_hora_funcion, total, dni, id_entrada from entrada where id_entrada=?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs != null) {
				while (rs.next()) {
					ent = new Entrada();
					ent.setNumero_butaca(rs.getInt("numero_butaca"));
					ent.setNro_sala(rs.getInt("nro_sala"));
					ent.setCod_pelicula(rs.getInt("cod_pelicula"));
					ent.setFecha_hora_funcion(rs.getObject("fecha_hora_funcion", LocalDateTime.class));
					ent.setTotal(rs.getDouble("total"));
					ent.setDni(rs.getString("dni"));
					ent.setId_entrada(rs.getInt("id_entrada"));
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
		return ent;
	}
	public void borrarEntrada(Entrada borraEnt) {
		
		DataButacaFuncion dbf = new DataButacaFuncion();
		ButacaFuncion bf = new ButacaFuncion();
		bf.setCod_pelicula(borraEnt.getCod_pelicula());
		bf.setFecha_hora_funcion(borraEnt.getFecha_hora_funcion());
		bf.setNro_sala(borraEnt.getNro_sala());
		bf.setNumero(borraEnt.getNumero_butaca());
		bf.setEstado(0);
		dbf.modificarButaca(bf);
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from entrada where id_entrada = ?");
			stmt.setInt(1, borraEnt.getId_entrada());
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
	
	
	public int contarEntradasPorFuncion(Funcion f) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		int cantidad = 0;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select count(*) from entrada e inner join funcion f on e.fecha_hora_funcion=f.fecha_hora\r\n"
					+ "where e.fecha_hora_funcion=? ");
			stmt.setObject(1, f.getFecha_hora());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				cantidad = rs.getInt("count(*)");
			}
	
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
		return cantidad;
	}
}
