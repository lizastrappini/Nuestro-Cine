package data;

import java.sql.*;
import java.util.LinkedList;
import entities.Calificacion;

public class DataCalificacion {

	public void cargarCalificacion(Calificacion nuevaCalificacion) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement(
					"insert into calificacion (descripcion) values (?)", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, nuevaCalificacion.getDescripcion());
			
			stmt.executeUpdate();
			
			rs= stmt.getGeneratedKeys();
			
			if(rs!= null && rs.next()) {
				nuevaCalificacion.setCodigo_calificacion(rs.getInt(1));
			}
			
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

	public LinkedList<Calificacion>listarCalificaciones(){
		Statement stmt= null;
		ResultSet rs=null;
		LinkedList<Calificacion>calificaciones = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select codigo_calificacion, descripcion from calificacion");
			if (rs != null ) {
				while (rs.next()) {
					Calificacion c = new Calificacion();
					c.setCodigo_calificacion(rs.getInt("codigo_calificacion"));
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
	}
	public Calificacion buscarCalificacion (Calificacion buscaCalificacion) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Calificacion cali = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select codigo_calificacion, descripcion from calificacion where codigo_calificacion = ?");
			stmt.setInt(1, buscaCalificacion.getCodigo_calificacion());
			
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
	}
	public void modificar(Calificacion cali) {
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
	}
}
