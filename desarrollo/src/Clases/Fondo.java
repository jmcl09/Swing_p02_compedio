/**
 * 
 */
package Clases;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Clase Fondo
 * 
 * Contiene método para pintar el fondo de una ventana con una imagen.
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class Fondo extends JPanel {

	// Atributos

	/**
	 * Ruta de la Imagen
	 */
	private String ruta;

	/**
	 * Constructor por defecto.
	 * 
	 * @param ruta ruta de la imagen
	 */
	public Fondo(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Sobreescribe un método de la clase JPanel donde recibe un objeto de tipo
	 * Graphics y dibuja la imagen en la ventana.
	 * 
	 * @paramg g objeto grafico
	 */
	@Override
	public void paint(Graphics g) {
		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}
}
