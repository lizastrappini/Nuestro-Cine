package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import entities.Compra;
import entities.Persona;




public class DataPersona {
	
	
	public String buscaNombre (Persona per) {
		//Persona p=null;
		String n = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select nombre from cliente where dni=?;"
					);
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null /*&& rs.next()*/) { 
				n=(rs.getString("nombre"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return n;
	}
	
	public LinkedList<Persona> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select dni,nombre,apellido,email,edad,telefono from cliente");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					p.setDni(rs.getString("dni"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setEmail(rs.getString("email"));
					p.setEdad(rs.getInt("edad"));
					p.setTelefono(rs.getString("telefono"));
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
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
		
		
		return pers;
	}
	
	public Persona getByUser(Persona per) {
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select nombre,apellido,dni,email,telefono,edad,habilitado from cliente where (email=? and password=?);"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setEdad(rs.getInt("edad"));
				p.setHabilitado(rs.getInt("habilitado"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public Persona search(Persona per) {
		Persona p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select dni,nombre,apellido,email,telefono from cliente where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			
			if (rs.next()) {
					p = new Persona();
					p.setDni(rs.getString("dni"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setEmail(rs.getString("email"));
					p.setTelefono(rs.getString("telefono"));

					
			}
		} catch (SQLException e){
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
		return p;
	}
	
	public Persona add(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into cliente"+"(dni,nombre, apellido, email, password,edad, telefono,habilitado) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getPassword());
			stmt.setInt(6, p.getEdad());
			stmt.setString(7, p.getTelefono());
			stmt.setInt(8, p.getHabilitado());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
      
            
			
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return p;
	}
	public String buscarPorDni(Persona per) {		
		String d = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select dni from cliente where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					
					d = rs.getString("dni");
					//System.out.println(p);
					
			}
		} catch (SQLException e){
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
		return d;
	}
	
	public String buscarPorMail(Persona per) {		
		String d = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select email from cliente where email=?");
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					
					d = rs.getString("email");
					//System.out.println(p);
					
			}
		} catch (SQLException e){
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
		return d;
	}
	
	public String obtenerPass(Persona per) {
		String p="";
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select password from cliente where email=?");
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					p=rs.getString("password");
					//System.out.println(p);

					
			}
		} catch (SQLException e){
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
		return p;
	}
	
	public void editPass(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update cliente set password=? where email=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getPassword());
			stmt.setString(2, p.getEmail());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
      
            
			
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
	}
	
	public LinkedList<Compra> getEntradas(Persona per) {
		Compra c = null;
		LinkedList<Compra>compras= new LinkedList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT UPPER(p.nombre) as 'nombre', date(e.fecha_hora_funcion) as 'fecha',time(e.fecha_hora_funcion) as 'hora', sum(e.total) as 'total', count(e.cod_pelicula) as 'cantidad' FROM cliente c inner join entrada e on c.dni=e.dni\n"
					+ "inner join pelicula p on e.cod_pelicula=p.codigo\n"
					+ "group by e.cod_pelicula, e.fecha_hora_funcion,e.dni\n"
					+ "having e.dni=?"
					);
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if (rs !=null) {
				while (rs.next()) {
				c=new Compra();
				c.setCantidad(rs.getInt("cantidad"));
				c.setHora(rs.getObject("hora",LocalTime.class));
				c.setTotal(rs.getDouble("total"));
				c.setFecha(rs.getObject("fecha",LocalDate.class));
				c.setNombre(rs.getString("nombre"));
				compras.add(c);

			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return compras;
	}
	
}


