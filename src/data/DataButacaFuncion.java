package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import entities.ButacaFuncion;
import entities.Funcion;

public class DataButacaFuncion {
	
	public void cargarButaca(ButacaFuncion nuevaButaca) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into butaca_funcion"
					+ "(nro_sala, cod_pelicula, fecha_hora_funcion, estado, numero) values (?,?,?,?,?)");
			
			stmt.setInt(1, nuevaButaca.getNro_sala());
			stmt.setInt(2, nuevaButaca.getCod_pelicula());
			stmt.setObject(3, nuevaButaca.getFecha_hora_funcion());
			stmt.setInt(4, nuevaButaca.getEstado());
			stmt.setInt(5, nuevaButaca.getNumero());
			
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
	
	public LinkedList<ButacaFuncion>listarButacas(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<ButacaFuncion>butacas= new LinkedList<>();
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("Select numero, nro_sala, cod_pelicula, fecha_hora_funcion, "
					+ "estado from butaca_funcion");
			if (rs !=null) {
				while (rs.next()) {
					ButacaFuncion bf = new ButacaFuncion();
					bf.setNumero(rs.getInt("numero"));
					bf.setNro_sala(rs.getInt("nro_sala"));
					bf.setCod_pelicula(rs.getInt("cod_pelicula"));
					bf.setFecha_hora_funcion(rs.getObject("fecha_hora_funcion", LocalDateTime.class));
					bf.setEstado(rs.getInt("estado"));
					butacas.add(bf);
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
		return butacas;
	}
	
	public void modificarButaca(ButacaFuncion bf) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update butaca_funcion "
					+ "set numero=?, nro_sala=?, cod_pelicula=?, fecha_hora_funcion=?, estado=? "
					+ "where cod_pelicula=? and fecha_hora_funcion=? and nro_sala=? and numero=?");
		
			stmt.setInt(1, bf.getCod_pelicula());
			stmt.setObject(2, bf.getFecha_hora_funcion());
			stmt.setInt(3, bf.getNro_sala());
			stmt.setInt(4, bf.getNumero());
			
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
	
	public void borrarButaca(ButacaFuncion borraButaca) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from butaca_funcion where cod_pelicula=? and fecha_hora_funcion=? and nro_sala=?");
			stmt.setInt(1, borraButaca.getCod_pelicula());
			stmt.setObject(2, borraButaca.getFecha_hora_funcion());
			stmt.setInt(3, borraButaca.getNro_sala());
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
	
	public LinkedList<ButacaFuncion> buscarButacasPorFuncion (Funcion fun) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<ButacaFuncion>butacas_funcion= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from butaca_funcion "
					+ "where cod_pelicula=? and nro_sala=? and fecha_hora_funcion=?");
			stmt.setInt(1, fun.getCodigo_pelicula());
			stmt.setInt(2, fun.getNumero_sala());
			stmt.setObject(3, fun.getFecha_hora());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
				ButacaFuncion but = new ButacaFuncion();
				but.setCod_pelicula(rs.getInt("cod_pelicula"));
				but.setFecha_hora_funcion(rs.getObject("fecha_hora_funcion", LocalDateTime.class));
				but.setNro_sala(rs.getInt("nro_sala"));
				
				butacas_funcion.add(but);
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
		return butacas_funcion;
	}
}
