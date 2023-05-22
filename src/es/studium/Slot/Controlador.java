package es.studium.Slot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	Modelo modelo;
	MenuPrincipal menuPrincipal;
	
	Tablero tablero;
	Ranking ranking;
	
	int num1, num2, num3;
	int dinero;
	int tiradas;
	
	Controlador(Modelo m, MenuPrincipal mp)
	{
		this.modelo = m;
		this.menuPrincipal = mp;
		
		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
		
		dinero = 5;
		tiradas = 0;
	}

	public void windowOpened(WindowEvent e){}

	public void windowClosing(WindowEvent e)
	{
		if(tablero!=null&&tablero.isActive())
		{
			tablero.setVisible(false);
		}
		else if(ranking!=null&&ranking.isActive())
		{
			ranking.setVisible(false);
		}
		else if(this.tablero.nombreJugador.isActive())
		{
			this.tablero.nombreJugador.setVisible(false);
			tablero.setVisible(false);
		}
		else
		{			
			System.exit(0);
		}
	}

	public void windowClosed(WindowEvent e){}

	public void windowIconified(WindowEvent e){}

	public void windowDeiconified(WindowEvent e){}

	public void windowActivated(WindowEvent e){}

	public void windowDeactivated(WindowEvent e){}

	public void mouseClicked(MouseEvent me)
	{
		int x = me.getX();
		int y = me.getY();
		
		if(menuPrincipal.isActive())
		{			
			if(x>20&&x<60&&y>50&&y<90)
			{
				// Primera opción: Tablero
				tablero = new Tablero();
				dinero = 5;
				tiradas = 0;
				this.tablero.addWindowListener(this);
				this.tablero.addMouseListener(this);
			}
			else if(x>80&&x<120&&y>100&&y<140)
			{
				// Segunda opción: Ayuda
				System.out.println("Ayuda");
			}
			else if(x>140&&x<180&&y>160&&y<200)
			{
				// Tercera opción: Ranking
				ranking = new Ranking();
				this.ranking.addWindowListener(this);
			}
			else if(x>200&&x<240&&y>210&&y<250)
			{
				// Cuarta opción: Salir
				System.exit(0);
			}
		}
		else if(tablero.isActive())
		{
			//Botón JUGAR de Tablero
			if(x>20&&x<250&&y>210&&y<250)
			{	
				dinero--;
				tiradas++;
				num1 = modelo.aleatorio();
				num2 = modelo.aleatorio();
				num3 = modelo.aleatorio();
				tablero.establecerPrimera(num1);
				tablero.establecerSegunda(num2);
				tablero.establecerTercera(num3);
				// Comprobar premios
				if(num1==num2&&num2==num3&&num1==14)
				{
					dinero = dinero + 25;
				}
				else if(num1==num2&&num2==num3&&num1>9&&num1<14)
				{
					dinero = dinero + 15;
				}
				else if(num1==num2&&num2==num3&&num1<=9)
				{
					dinero = dinero + 5;
				}
				else if(num1==num2 || num1==num3 || num2 == num3)
				{
					dinero = dinero + 3;
				}
			}
			else if(x>20&&x<90&&y>140&&y<160)
			{
				num1++;
				dinero--;
				if(num1>14)
				{
					num1 = 1;
				}
				tablero.establecerPrimera(num1);
			}
			else if(x>100&&x<170&&y>140&&y<160)
			{
				num2++;
				dinero--;
				if(num2>14)
				{
					num2 = 1;
				}
				tablero.establecerSegunda(num2);
			}
			else if(x>180&&x<250&&y>140&&y<160)
			{
				num3++;
				dinero--;
				if(num3>14)
				{
					num3 = 1;
				}
				tablero.establecerTercera(num3);
			}
			if(dinero==0)
			{
				System.out.println("Se acabó");
				System.out.println("Has realizado " + tiradas + " tiradas");
				this.tablero.removeMouseListener(this);
				this.tablero.nombreJugador.addWindowListener(this);
				this.tablero.nombreJugador.addMouseListener(this);
				this.tablero.btnAceptar.addActionListener(this);
				this.tablero.nombreJugador.setVisible(true);
			}
			else
			{					
				System.out.println("Tienes " + dinero + "€");
			}
		}
	}

	public void mousePressed(MouseEvent me){}

	public void mouseReleased(MouseEvent me){}

	public void mouseEntered(MouseEvent me){}

	public void mouseExited(MouseEvent me){}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Guardar el nombre en la BD
		String nombre = this.tablero.txtNombre.getText();
		Connection c = modelo.conectar();
		modelo.insertar(c, nombre, tiradas);
		// Cerrar el diálogo
		this.tablero.nombreJugador.setVisible(false);
		tablero.setVisible(false);
	}
}
