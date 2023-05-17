package es.studium.Slot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener
{
	Modelo modelo;
	MenuPrincipal menuPrincipal;
	
	Tablero tablero;
	Ranking ranking;
	
	int num1, num2, num3;
	int dinero;
	
	Controlador(Modelo m, MenuPrincipal mp)
	{
		this.modelo = m;
		this.menuPrincipal = mp;
		
		this.menuPrincipal.addWindowListener(this);
		this.menuPrincipal.addMouseListener(this);
		
		dinero = 5;
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
				num1 = modelo.aleatorio();
				num2 = modelo.aleatorio();
				num3 = modelo.aleatorio();
				// Comprobar premios
				if(num1==num2&&num2==num3&&num1==14)
				{
					dinero = dinero + 50;
				}
				else if(num1==num2&&num2==num3&&num1>9&&num1<14)
				{
					dinero = dinero + 25;
				}
				else if(num1==num2&&num2==num3&&num1<=9)
				{
					dinero = dinero + 10;
				}
				if(dinero==0)
				{
					System.out.println("Se acabó");
					this.tablero.removeMouseListener(this);
				}
				else
				{					
					System.out.println("Tienes " + dinero + "€");
				}
			}
		}
	}

	public void mousePressed(MouseEvent me){}

	public void mouseReleased(MouseEvent me){}

	public void mouseEntered(MouseEvent me){}

	public void mouseExited(MouseEvent me){}
}
