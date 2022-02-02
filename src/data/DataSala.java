package data;

import java.sql.*;
import java.util.LinkedList;
import entities.Sala;

public class DataSala {

	public void cargarSala(Sala nuevaSala) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("insert into sala"
					+ "(numero) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1,  nuevaSala.getNumero());
			
			stmt.executeUpdate();
			
			rs= stmt.getGeneratedKeys();
			
			if(rs!= null && rs.next()) {
				nuevaSala.setNumero(rs.getInt(1));
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

	public LinkedList<Sala>listarSalas(){
		Statement stmt= null;
		ResultSet rs=null;
		LinkedList<Sala>salas = new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select numero from sala");
			if (rs != null ) {
				while (rs.next()) {
					Sala s = new Sala();
					s.setNumero(rs.getInt("numero"));
					
					salas.add(s);
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
		return salas;
	}
	
	public Sala buscarSala (Sala buscaSala) {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Sala sal = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from sala where numero = ?");
			stmt.setInt(1, buscaSala.getNumero());
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				sal = new Sala();
				sal.setNumero(rs.getInt("numero"));
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
		
		return sal;
	}

	public void modificar(Sala sal) {
		PreparedStatement stmt =null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update sala set numero=? where numero=?");
			
			stmt.setInt(1, sal.getNumero());
			stmt.setInt(2, sal.getNumero());
			
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
	
	public void borrarSala(Sala borraSala) {
		PreparedStatement stmt=null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("delete from sala where numero=?");
			stmt.setInt(1, borraSala.getNumero());
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

}

