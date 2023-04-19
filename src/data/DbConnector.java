package data;

import java.sql.*;


public class DbConnector {

	private static DbConnector instancia;
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="java";
	private String password="himitsu";
	private String db="tp_java_cine";
	private int conectados=0;
	private Connection conn=null;
	
	
	public DbConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstancia() {
		if (instancia == null) {
			instancia = new DbConnector();
		}
		return instancia;
	}
	
	public Connection getConn(){ 
			
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password); //se crea la conexion a la BBDD
				conectados=0;
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close(); //cierro conexion con la BBDD
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

