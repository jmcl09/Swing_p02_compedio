/**
 * 
 */
package Paneles;

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Clase PanelDatos
 * 
 * Contiene el panel donde se añadiran los datos una vez pulsemos el boton
 * imprimir.
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class PanelDatos extends JPanel {

	/**
	 * Panel de Pestañas
	 */
	private static JTabbedPane tp = new JTabbedPane();
	/**
	 * Paneles para cada pestaña
	 */
	static JPanel p1, p2;

	/**
	 * Contenedor donde pintaremos los datos.
	 */
	static JEditorPane jt1, jt2;

	/**
	 * Constructor sin parametros
	 */
	public PanelDatos() {
		this.setLayout(new BorderLayout());

		/** Pestaña 1 **/
		p1 = new JPanel();
		p1.setLayout(null);

		/** Pestaña 2 **/
		p2 = new JPanel();
		p2.setLayout(null);

		/** Texto 1 **/
		jt1 = new JEditorPane();
		jt1.setBounds(5, 0, 800, 200);
		jt1.setContentType("text/html");
		jt1.setEditable(false);
		p1.add(jt1);

		/** Texto 2 **/
		jt2 = new JEditorPane();
		jt2.setBounds(5, 0, 800, 200);
		jt2.setContentType("text/html");
		jt2.setEditable(false);
		p2.add(jt2);

		tp.addTab("Datos del Cliente", p1);
		tp.addTab("Datos de la Habitación", p2);

		this.add(tp);

		this.setVisible(true);

	}

}
