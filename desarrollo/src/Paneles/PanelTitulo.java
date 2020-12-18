/**
 * 
 */
package Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * Clase PanelTitulo
 * 
 * Contiene el panel con el titulo
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class PanelTitulo extends JPanel {

	/**
	 * Titulo y las dos palmeras como icono
	 */
	private static JLabel titulo, palmera1, palmera2;
	/**
	 * Fuente personalizada para nuestras etiquetas
	 */
	private Font fuenteTitulo = new Font("MV Boli", 1, 55);
	/**
	 * Iconos
	 */
	private static ImageIcon palm1, palm2, pl1, pl2;

	/**
	 * Constructor sin parametros
	 */
	public PanelTitulo() {
		this.setLayout(new BorderLayout());

		palm1 = new ImageIcon(getClass().getResource("/Recursos/palmerav11.png"));
		pl1 = new ImageIcon(palm1.getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT));
		palm2 = new ImageIcon(getClass().getResource("/Recursos/palmerav22.png"));
		pl2 = new ImageIcon(palm2.getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT));

		palmera1 = new JLabel();
		palmera1.setIcon(pl1);

		titulo = new JLabel("Gran Resort - El Continental ", SwingConstants.CENTER);
		titulo.setFont(fuenteTitulo);

		palmera2 = new JLabel();
		palmera2.setIcon(pl2);

		this.setBorder(new EtchedBorder());
		this.setBackground(new Color(240, 238, 191, 200));

		this.add(palmera1, BorderLayout.LINE_START);
		this.add(titulo, BorderLayout.CENTER);
		this.add(palmera2, BorderLayout.LINE_END);

		this.setVisible(true);
	}

}
