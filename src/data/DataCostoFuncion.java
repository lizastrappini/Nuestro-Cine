package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.Costo_funcion;
import entities.Funcion;

public class DataCostoFuncion {
	public void cargarCostoFuncion(Costo_funcion nuevoCostoFuncion) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into costo_funcion"
					+ "(cod_pelicula, fecha_actualizacion, costo, fecha_hora_fun, nro_sala) values (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, nuevoCostoFuncion.getCod_pelicula());
			stmt.setObject(2, nuevoCostoFuncion.getFecha_actualizacion());
			stmt.setDouble(3, nuevoCostoFuncion.getCosto());
			stmt.setObject(4, nuevoCostoFuncion.getFecha_hora_fun());
			stmt.setInt(5, nuevoCostoFuncion.getNro_sala());
			
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			
			if(rs != null && rs.next()) {
				nuevoCostoFuncion.setCod_pelicula(rs.getInt(1));
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
	public LinkedList<Costo_funcion>listarCostosFunciones(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Costo_funcion>costos_funciones= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select cod_pelicula, fecha_actualizacion, costo, fecha_hora_fun, nro_sala"
					+ " from costo_funcion");
			if (rs !=null) {
				while (rs.next()) {
					Costo_funcion cf = new Costo_funcion();
					cf.setCod_pelicula(rs.getInt("cod_pelicula"));
					//cf.setFecha_actualizacion(rs.getObject("fecha_actualizacion"));
					cf.setCosto(rs.getDouble("costo"));
					cf.setFecha_hora_fun(rs.getObject("fecha_hora_fun", LocalDateTime.class));
					cf.setNro_sala(rs.getInt("nro_sala"));
					costos_funciones.add(cf);
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
		return costos_funciones;
	}
	public LinkedList<Costo_funcion> buscarCostoFuncionPorFuncion (Costo_funcion buscaCostoFun) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Costo_funcion>costos_funciones_funcion= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from costo_funcion where cod_pelicula=?");
			stmt.setInt(1, buscaCostoFun.getCod_pelicula());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
				Costo_funcion costo_fun = new Costo_funcion();
				costo_fun.setCod_pelicula(rs.getInt("cod_pelicula"));
				//costo_fun.setFecha_actualizacion(rs.getObject("fecha_hora", LocalDateTime.class));
				costo_fun.setCosto(rs.getDouble("costo"));
				costo_fun.setFecha_hora_fun(rs.getObject("fecha_hora_fun", LocalDateTime.class));
				costo_fun.setNro_sala(rs.getInt("nro_sala"));
				
				costos_funciones_funcion.add(costo_fun);
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
		return costos_funciones_funcion;
	}
}
