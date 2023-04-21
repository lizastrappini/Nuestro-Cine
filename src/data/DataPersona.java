package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.Persona;

public class DataPersona {
	
	
	public String buscaNombre (Persona per) {
		String n = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select nombre from persona where dni=?;"
					);
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null) { 
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
			rs= stmt.executeQuery("select dni,nombre,apellido,email,edad,telefono from persona");
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
					"select nombre,apellido,dni,email,telefono,edad,habilitado from persona where (email=? and password=?);"
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
					"select dni,nombre,apellido,email,telefono from persona where dni=?");
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
							"insert into persona"+"(dni,nombre, apellido, email, password,edad, telefono,habilitado) values(?,?,?,?,?,?,?,?)",
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
					"select dni from persona where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					
					d = rs.getString("dni");

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
					"select email from persona where email=?");
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					
					d = rs.getString("email");

					
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
					"select password from persona where email=?");
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
					p=rs.getString("password");


					
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
							"update persona set password=? where email=?",
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
	
	
	public void borrarPersona(Persona per) {
		PreparedStatement stmt=null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from persona where dni = ?");
			stmt.setString(1, per.getDni());
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
	
	public void editPersona(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update persona set nombre=?,apellido=?,edad=?,telefono=? where dni=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setInt(3, p.getEdad());
			stmt.setString(4, p.getTelefono());
			stmt.setString(5, p.getDni());
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
	
}


