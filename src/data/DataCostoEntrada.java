package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.CostoEntrada;

public class DataCostoEntrada {
	
	public void cargarCostoEntrada(CostoEntrada nuevoCostoEntrada) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into costo_entrada"
					+ "(fecha_desde, costo) values (?,?)");
			
			java.sql.Date date = nuevoCostoEntrada.convertirFecha(nuevoCostoEntrada.getFecha_desde());			
			stmt.setDate(1, date);
			stmt.setDouble(2, nuevoCostoEntrada.getCosto());
			
			stmt.executeUpdate();
			
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
	
	public LinkedList<CostoEntrada>listarCostosEntradas(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<CostoEntrada>costos_entradas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select fecha_desde, costo from costo_entrada");
			
			if (rs !=null) {
				while (rs.next()) {
					CostoEntrada ce = new CostoEntrada();
					ce.setFecha_desde(rs.getObject("fecha_desde",Date.class));
					ce.setCosto(rs.getDouble("costo"));
					costos_entradas.add(ce);
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
		return costos_entradas;
	}
	
	public CostoEntrada buscarCostoActual() {
		ResultSet rs = null;
		PreparedStatement stmt=null;
		CostoEntrada costo = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("drop temporary table if exists ult_valor;\n"
					+ "create temporary table ult_valor\n"
					+ "\n"
					+ "select max(fecha_desde) ult_fecha\n"
					+ "from costo_entrada\n"
					+ "where fecha_desde <= current_date();\n"
					+ "\n"
					+ "select uv.ult_fecha, ce.costo\n"
					+ "from costo_entrada ce\n"
					+ "inner join ult_valor uv\n"
					+ "on ce.fecha_desde=uv.ult_fecha;");
			
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				costo = new CostoEntrada();
				costo.setFecha_desde(rs.getObject("uv.ult_fecha", Date.class));
				costo.setCosto(rs.getDouble("ce.costo"));
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
		
		return costo;

	}
	
}
