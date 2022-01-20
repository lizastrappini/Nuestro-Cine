package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import entities.Funcion;
import entities.ButacaFuncion;
import entities.Sala;

public class DataFuncion {
	
	public void cargarFuncion(Funcion nuevaFuncion) {
		PreparedStatement stmt=null;
		ResultSet rs = null;
		
		try {						
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"insert into funcion (codigo_pelicula, fecha_hora, numero_sala) values (?,?,?)");
			
			stmt.setInt(1, nuevaFuncion.getCodigo_pelicula());
			stmt.setObject(2, nuevaFuncion.getFecha_hora());
			stmt.setInt(3, nuevaFuncion.getNumero_sala());
			
			stmt.executeUpdate();
			
			Sala s = new Sala();
			s.setNumero(nuevaFuncion.getNumero_sala());
			DataSala ds = new DataSala();
			Sala sal = ds.buscarSala(s);
			
			DataButacaFuncion dbf = new DataButacaFuncion();
			
			for(int i = 1; i <= sal.getCupo(); ++i){ 
				ButacaFuncion nuevaButaca = new ButacaFuncion();
				nuevaButaca.setCod_pelicula(nuevaFuncion.getCodigo_pelicula());
				nuevaButaca.setFecha_hora_funcion(nuevaFuncion.getFecha_hora());
				nuevaButaca.setNro_sala(nuevaFuncion.getNumero_sala());
				nuevaButaca.setEstado(0);
				dbf.cargarButaca(nuevaButaca);
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
	
	public LinkedList<Funcion>listarFunciones(){
		Statement stmt= null;
		ResultSet rs= null;
		LinkedList<Funcion>funciones= new LinkedList<>();
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
	}
	public LinkedList<Funcion> buscarFuncionPorPeli (Funcion buscaFun) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		LinkedList<Funcion>funciones_peli= new LinkedList<>();
		
		try {
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("select * from funcion where codigo_pelicula=?");
			stmt.setInt(1, buscaFun.getCodigo_pelicula());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
				Funcion fun = new Funcion();
				fun.setCodigo_pelicula(rs.getInt("codigo_pelicula"));
				fun.setFecha_hora(rs.getObject("fecha_hora", LocalDateTime.class));
				fun.setNumero_sala(rs.getInt("numero_sala"));
				
				funciones_peli.add(fun);
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
		return funciones_peli;
	}
	
	public void modificarFuncion(Funcion f) {
		PreparedStatement stmt=null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("update funcion "
					+ "set codigo_pelicula=?, fecha_hora=?, numero_sala=? where codigo_pelicula=?"
					+ "and fecha_hora=? and numero_sala=?");
		
			stmt.setInt(1, f.getCodigo_pelicula());
			stmt.setObject(2, f.getFecha_hora());
			stmt.setInt(3, f.getNumero_sala());
			
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
	
	public void borrarPelicula(Funcion borraFun) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from funcion where"
					+ "codigo_pelicula=? and fecha_hora=? and numero_sala=?");
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
	}	
}
