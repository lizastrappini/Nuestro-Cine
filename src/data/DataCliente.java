package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Cliente;



public class DataCliente {
	public LinkedList<Cliente> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Cliente> clis= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select dni,nombre,apellido,email,edad,telefono from cliente");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Cliente c=new Cliente();
					c.setDni(rs.getString("dni"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setEmail(rs.getString("email"));
					c.setEdad(rs.getInt("edad"));
					c.setTelefono(rs.getString("telefono"));
					
					clis.add(c);
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
		
		
		return clis;
	}
	
	public Cliente getByUser(Cliente cli) {
		Cliente c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select nombre from cliente where email=? and contraseña=?"
					);
			stmt.setString(1, cli.getEmail());
			stmt.setString(2, cli.getContraseña());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Cliente();
				c.setNombre(rs.getString("nombre"));
				//
				
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
		
		return c;
	}
	
	public LinkedList<Cliente> search(Cliente cli) {
		LinkedList<Cliente> clis= new LinkedList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select dni,nombre,apellido,email,telefono from cliente where dni=?");
			stmt.setString(1, cli.getDni());
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Cliente c = new Cliente();
					c.setDni(rs.getString("dni"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setEmail(rs.getString("email"));
					c.setTelefono(rs.getString("telefono"));

					clis.add(c);
				
				}
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
		return clis;
	}
	
	public Cliente add(Cliente c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into cliente(dni,nombre, apellido, email, contraseña,edad, telefono ) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, c.getDni());
			stmt.setString(2, c.getNombre());
			stmt.setString(3, c.getApellido());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getContraseña());
			stmt.setString(6, c.getTelefono());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
            	            }
            
			
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
		return c;
	}
	
}
