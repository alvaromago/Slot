package es.studium.Slot;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class Tablero extends Frame
{
	private static final long serialVersionUID = 1L;
	
	Image cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce, trece, catorce;
	Image primera, segunda, tercera;
	Toolkit herramienta;

	Dialog nombreJugador = new Dialog(this, "Nombre Jugador", true);
	Label lblNombre = new Label("Dame tu nombre, perdedor.");
	TextField txtNombre = new TextField(12);
	Button btnAceptar = new Button("Guardar");
	
	Tablero()
	{
		setTitle("Jugando...");
		setSize(280, 280);
		setResizable(false);
		setLocationRelativeTo(this);
		herramienta = getToolkit();
		cero = herramienta.getImage("imagenes/cero.png");
		uno = herramienta.getImage("imagenes/uno.png");
		dos = herramienta.getImage("imagenes/dos.png");
		tres = herramienta.getImage("imagenes/tres.png");
		cuatro = herramienta.getImage("imagenes/cuatro.png");
		cinco = herramienta.getImage("imagenes/cinco.png");
		seis = herramienta.getImage("imagenes/seis.png");
		siete = herramienta.getImage("imagenes/siete.png");
		ocho = herramienta.getImage("imagenes/ocho.png");
		nueve = herramienta.getImage("imagenes/nueve.png");
		diez = herramienta.getImage("imagenes/diez.png");
		once = herramienta.getImage("imagenes/once.png");
		doce = herramienta.getImage("imagenes/doce.png");
		trece = herramienta.getImage("imagenes/trece.png");
		catorce = herramienta.getImage("imagenes/catorce.png");
		
		nombreJugador.setSize(180, 140);
		nombreJugador.setLayout(new FlowLayout());
		nombreJugador.add(lblNombre);
		nombreJugador.add(txtNombre);
		nombreJugador.add(btnAceptar);
		
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(primera, 20, 50, this);
		g.setColor(Color.green);
		g.fillRoundRect(20, 140, 70, 20, 10, 10);
		g.drawImage(segunda, 100, 50, this);
		g.fillRoundRect(100, 140, 70, 20, 10, 10);
		g.drawImage(tercera, 180, 50, this);
		g.fillRoundRect(180, 140, 70, 20, 10, 10);
		g.setColor(Color.black);
		g.drawRect(20, 210, 230, 40);
		g.drawString("JUGAR", 110, 240);
	}

	public void establecerPrimera(int aleatorio)
	{
		switch(aleatorio)
		{
		case 1:
			primera = uno;
			break;
		case 2:
			primera = dos;
			break;
		case 3:
			primera = tres;
			break;
		case 4:
			primera = cuatro;
			break;
		case 5:
			primera = cinco;
			break;
		case 6:
			primera = seis;
			break;
		case 7:
			primera = siete;
			break;
		case 8:
			primera = ocho;
			break;
		case 9:
			primera = nueve;
			break;
		case 10:
			primera = diez;
			break;
		case 11:
			primera = once;
			break;
		case 12:
			primera = doce;
			break;
		case 13:
			primera = trece;
			break;
		case 14:
			primera = catorce;
			break;
		default:
			primera = cero;
		}
		repaint();
	}
	
	public void establecerSegunda(int aleatorio)
	{
		switch(aleatorio)
		{
		case 1:
			segunda = uno;
			break;
		case 2:
			segunda = dos;
			break;
		case 3:
			segunda = tres;
			break;
		case 4:
			segunda = cuatro;
			break;
		case 5:
			segunda = cinco;
			break;
		case 6:
			segunda = seis;
			break;
		case 7:
			segunda = siete;
			break;
		case 8:
			segunda = ocho;
			break;
		case 9:
			segunda = nueve;
			break;
		case 10:
			segunda = diez;
			break;
		case 11:
			segunda = once;
			break;
		case 12:
			segunda = doce;
			break;
		case 13:
			segunda = trece;
			break;
		case 14:
			segunda = catorce;
			break;
		default:
			segunda = cero;
		}
		repaint();
	}
	
	public void establecerTercera(int aleatorio)
	{
		switch(aleatorio)
		{
		case 1:
			tercera = uno;
			break;
		case 2:
			tercera = dos;
			break;
		case 3:
			tercera = tres;
			break;
		case 4:
			tercera = cuatro;
			break;
		case 5:
			tercera = cinco;
			break;
		case 6:
			tercera = seis;
			break;
		case 7:
			tercera = siete;
			break;
		case 8:
			tercera = ocho;
			break;
		case 9:
			tercera = nueve;
			break;
		case 10:
			tercera = diez;
			break;
		case 11:
			tercera = once;
			break;
		case 12:
			tercera = doce;
			break;
		case 13:
			tercera = trece;
			break;
		case 14:
			tercera = catorce;
			break;
		default:
			tercera = cero;
		}
		repaint();
	}
}
