package es.studium.Slot;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class Modelo
{
	Modelo()
	{
		
	}
	
	// Método aleatorio
	public int aleatorio()
	{
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(14)+1;
		return(numero);
	}
	// Conexión
	public Connection conectar()
	
	{
		Connection connection = null;
		return connection;
	}
	// Desconexión
	public void desconectar(Connection c)
	{
		try
		{
			c.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	// Consultar para el Ranking
	public String ranking(Connection c)
	{
		String contenido = "";
		String sentencia = "select * from ranking order by puntos desc limit 10";
		return(contenido);
	}
	// Insertar en BD
	public void insertar(Connection c, String nombre, int puntos)
	{
		String sentencia = "insert into ranking values (null, '" + nombre + "', " + puntos + ");";
	}
}
