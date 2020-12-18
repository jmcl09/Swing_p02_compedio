package Clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Paneles.VentanaAltaReservas;

/**
 * Clase Ventana.
 *
 * Contiene todos los datos para poder crear una Ventana con sus componentes
 * 
 * @author Jose Manuel Cruzado Lorente
 */
@SuppressWarnings("serial")
public class Ventana extends JFrame{

	/**
	 * Ancho y Alto de la pantalla
	 */
	private static int ancho, alto;


	/**
	 * Fondo del Panel
	 */
	private static Fondo panel = new Fondo("/Recursos/resort.jpg");


	/**
	 * Botones de alta y baja reservas, y paleta de colores
	 */
	private static JButton altas, bajas, paleta;


	public Ventana() {
		this.tamanioPosicion();
		this.setTitle("Gestión Hotel - El Continental");
		this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/icon.png")).getImage());
		this.setResizable(false);

		this.setMenu();

		panel.setLayout(null);
		panel.setSize(ancho,alto);

		altas = new JButton("Altas Reservas");
		bajas = new JButton("Bajas Reservas");
		paleta = new JButton("Paleta de Colores");

		altas.setBounds((ancho/4)-100, (alto/2)-50, 200,100);
		bajas.setBounds(((ancho/4)*3)-100, (alto/2)-50, 200, 100);
		paleta.setBounds((ancho/4)-25, (alto/2)+100, (ancho/2), 50);
		paleta.setToolTipText("Cambiar color de los botones.");

		altas.addActionListener(e -> {this.abrirAlta();});
		altas.setMnemonic(KeyEvent.VK_A);

		bajas.addActionListener(e -> {this.abrirBaja();});
		bajas.setMnemonic(KeyEvent.VK_B);

		paleta.addActionListener(e -> {this.abrirPaleta();});


		panel.add(altas);
		panel.add(bajas);
		panel.add(paleta);

		this.add(panel);

		this.setVisible(true);
	}


	/**
	 * Metodo para poner la barra de menu
	 */
	private void setMenu() {
		JMenuBar jmb = new JMenuBar();

		JMenu archivo = new JMenu("Archivo");
		JMenu registro = new JMenu("Registro");
		JMenu help = new JMenu("Ayuda");

		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem altaR = new JMenuItem("Alta Reservas");
		JMenuItem bajaR = new JMenuItem("Baja Reservas");
		JMenuItem ayuda = new JMenuItem("Acerca de...");

		salir.addActionListener(e -> {System.exit(0);});
		altaR.addActionListener(e -> {this.abrirAlta();});
		bajaR.addActionListener(e -> {
			abrirBaja();
		});
		ayuda.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Empresa: Resort Continental JM"
					+ "\nÉsta aplicación es un gestor de reservas de la Resort El Continental.",
					"Información Básica..", JOptionPane.INFORMATION_MESSAGE);
		});

		archivo.add(salir);
		registro.add(altaR);
		registro.add(bajaR);
		help.add(ayuda);

		jmb.add(archivo);
		jmb.add(registro);
		jmb.add(help);

		registro.setMnemonic(KeyEvent.VK_R);

		this.setJMenuBar(jmb);
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
		this.setBounds(ancho / 4, alto / 4, ancho / 2, alto / 2);

		/**
		 * Cambiamos el valor de las variables
		 * y las igualamos a la resolucion de 
		 * la ventana, que es igual a la mitad de nuestra
		 * pantalla.
		 */
		ancho /= 2;
		alto /= 2;

	}

	/**
	 * Metodo que abre una ventana Modal donde podremos
	 * dar de Alta Reservas.
	 */
	private void abrirAlta() {

		VentanaAltaReservas p = new VentanaAltaReservas(this, true);
		p.setVisible(true);

	}

	/**
	 * Metodo para cuando pulsemos en Baja Reservas indicarnos que no está disponible.
	 */
	private void abrirBaja() {
		JOptionPane.showMessageDialog(this, "Esta funcionalidad aún no está disponible."
				, "ADVERTENCIA!!", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Metodo para abrir una ventana de eleccion de paleta de colores.
	 * 
	 */
	private void abrirPaleta() {

		Color defaultC = Color.RED;
		Color color = JColorChooser.showDialog(this, "Selecciona un color!", defaultC);
		altas.setBackground(color);
		bajas.setBackground(color);
		paleta.setBackground(color);

	}
}

