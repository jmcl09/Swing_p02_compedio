/**
 * 
 */
package Paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Clases.Fondo;
import Clases.Ventana;

/**
 * Clase VentanaAltaReservas
 * 
 * Clase que contiene todos los paneles de cada una de las secciones de nuestra
 * aplicacion
 * 
 * @author José Manuel Cruzado Lorente
 *
 */

@SuppressWarnings("serial")
public class VentanaAltaReservas extends JDialog {

	/**
	 * Clase Fondo que nos establece de fondo una imagen
	 */
	private static Fondo panel = new Fondo("/Recursos/resortAltas.jpg");
	/**
	 * Ancho y Alto de la pantalla
	 */
	private int ancho, alto;
	/**
	 * PanelTitulo
	 */
	private static PanelTitulo pt = new PanelTitulo();
	/**
	 * PanelFormulario
	 */
	private static PanelFormulario pf = new PanelFormulario();
	/**
	 * PanelHabs
	 */
	private static PanelHabs ph = new PanelHabs();
	/**
	 * PanelDatos
	 */
	private static PanelDatos pd = new PanelDatos();
	/**
	 * PanelBotones
	 */
	private static PanelBotones pb = new PanelBotones();

	/**
	 * Constructor sin parametros
	 * 
	 * @param v     ventana de la que hereda
	 * @param modal hace la ventana modal o no
	 */
	public VentanaAltaReservas(Ventana v, boolean modal) {
		super(v, modal);

		this.tamanioPosicion();
		this.setTitle("Alta Reservas - El Continental");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/icon.png")).getImage());
		this.setResizable(false);
		this.setSize(ancho, alto);
		this.setLocationRelativeTo(null);

		panel.setLayout(new GridLayout(5, 1));
		panel.setSize(ancho, alto);

		setPaneles();

		this.add(panel);
	}

	/**
	 * Definimos el ancho y alto de la ventana al igual que su posicion.
	 */
	private void tamanioPosicion() {

		/** Creamos el objeto ToolKit */
		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		/** Obtenemos la resolución */
		Dimension tamanioPantalla = miPantalla.getScreenSize();

		/** Obtenemos el ancho y alto de la pantalla */
		alto = tamanioPantalla.height;
		ancho = tamanioPantalla.width;

		/** Posicionamos y redimensionamos **/
		this.setSize(ancho, alto);
	}

	/**
	 * Añadimos todos los paneles a la ventana.
	 */
	private void setPaneles() {
		Border bordejpanel = new TitledBorder(new MatteBorder(5, 5, 10, 15, Color.DARK_GRAY), "Jose Manuel Cruzdao L.");
		pt.setBorder(bordejpanel);

		panel.add(pt);
		panel.add(pf);
		panel.add(ph);
		panel.add(pd);
		panel.add(pb);
	}

}
