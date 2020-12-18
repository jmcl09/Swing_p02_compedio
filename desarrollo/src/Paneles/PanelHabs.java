package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Clase PanelHabs
 * 
 * Contiene lo necesario para instanciar un panel con los datos necesarios a
 * rellenar sobre las habitaciones
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class PanelHabs extends JPanel {

	/**
	 * Lista los tres tipos de habitacion que hay
	 */
	static JComboBox<String> tiposHab = new JComboBox<String>(new String[] { "Simple", "Doble", "Suite" });
	/**
	 * Indica el numero de habitaciones que quiere el Cliente
	 */
	static JSpinner nHab = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
	/**
	 * Indica la edad del ni�o
	 */
	static JSpinner edad = new JSpinner(new SpinnerNumberModel(0, 0, 14, 1));
	/**
	 * Distintas etiquetas para definir campos
	 */
	static JLabel lHab, lCama, lTotal, lTiposHab, lnHab, lEdad, lImporteNi�o, imagen;
	/**
	 * Marca la existencia de ni�os o no
	 */
	static JCheckBox ni�os = new JCheckBox("Ni�os");
	/**
	 * Panel para a�adir la ficha a rellenar en caso de haber ni�os
	 */
	private static JPanel pNi�os = new JPanel();
	/**
	 * Botones para cambiar de imagen
	 */
	private static JButton prev, next;
	/**
	 * Imagen predeterminada de las habitaciones
	 */
	private ImageIcon icono = new ImageIcon(getClass().getResource("/Recursos/2.jpg"));
	/**
	 * Contador para movernos entre las imagenes
	 */
	private static int contador = 2;
	/**
	 * Fuente personalizada para las etiquetas
	 */
	private static Font fuente = new Font("MV Boli", 1, 12);
	/**
	 * Lista de Componentes
	 */
	private static JComponent listaC[];

	/**
	 * Constructor sin parametros
	 */
	public PanelHabs() {
		this.setLayout(null);
		this.setBackground(new Color(179, 209, 58, 200));

		this.posicionarElementos();

		agregarEventos();

		establecerFuente();

		this.agregarComponentes();

		prev.addActionListener(e -> {
			this.cambiarImagen(e);
		});
		next.addActionListener(e -> {
			this.cambiarImagen(e);
		});
		tiposHab.addActionListener(e -> {
			this.cambiarCama();
			comprobarPrecioFinal();
		});

		this.setVisible(true);
	}

	/**
	 * Posicionamos todos los elementos en el panel
	 */
	private void posicionarElementos() {
		lTiposHab = new JLabel("Tipos de Habitaci�n: ");
		lTiposHab.setBounds(100, 40, 150, 30);
		tiposHab.setBounds(240, 40, 100, 30);

		lnHab = new JLabel("N� Habitaciones:");
		lnHab.setBounds(450, 40, 130, 30);
		nHab.setBounds(560, 40, 100, 30);

		ni�os.setBounds(100, 80, 100, 20);
		pNi�os.setBounds(100, 100, 340, 80);
		pNi�os.setLayout(null);

		lEdad = new JLabel("Edad del ni�o:");
		lEdad.setBounds(10, 10, 100, 20);
		pNi�os.add(lEdad);
		edad.setBounds(110, 10, 50, 20);
		pNi�os.add(edad);

		lCama = new JLabel("Cama: Ninguna");
		lCama.setBounds(170, 10, 200, 20);
		pNi�os.add(lCama);

		lImporteNi�o = new JLabel("Importe Adicional: 0�");
		lImporteNi�o.setBounds(110, 40, 180, 20);
		pNi�os.add(lImporteNi�o);

		lTotal = new JLabel("Importe Total: 50�");
		lTotal.setBounds(450, 150, 180, 30);

		prev = new JButton("<");
		prev.setBounds(680, 80, 60, 30);

		imagen = new JLabel();
		imagen.setIcon(icono);
		imagen.setBounds(750, 10, 300, 170);

		next = new JButton(">");
		next.setBounds(1060, 80, 60, 30);

		listaC = new JComponent[] { lCama, lTotal, lTiposHab, lnHab, lEdad, lImporteNi�o, imagen, prev, next };

		comprobarEstadoPanel();

	}

	/**
	 * Agregamos los eventos necesarios a cada componente
	 */
	private static void agregarEventos() {
		ni�os.addActionListener(e -> {
			comprobarEstadoPanel();
			comprobarPrecioFinal();
		});
		edad.addChangeListener(e -> {
			int valor = (Integer) edad.getValue();
			if (valor >= 0 && valor <= 3) {
				lCama.setText("Cama: Cuna");
			} else if (valor > 3 && valor <= 10) {
				lCama.setText("Cama: Supletoria Peque�a");

			} else {
				lCama.setText("Cama: Supletoria Normal");
			}
		});
		nHab.addChangeListener(e -> {
			comprobarPrecioFinal();
		});

	}

	/**
	 * Cambiar la foto de la habitaci�n seg�n el tipo de habitaci�n que elija.
	 */
	private void cambiarCama() {
		String tCama = tiposHab.getSelectedItem().toString();
		switch (tCama) {
		case "Suite":
			contador = 3;
			break;
		case "Simple":
			contador = 2;
			break;
		case "Doble":
			contador = 1;
			break;
		}
		icono = new ImageIcon(getClass().getResource("/Recursos/" + contador + ".jpg"));
		imagen.setIcon(icono);
	}

	/**
	 * Comprobamos el precio final
	 */
	private static void comprobarPrecioFinal() {
		int numHabitaciones = new Integer((int) nHab.getValue());
		int t = 0;
		if (ni�os.isSelected()) {
			t += 20;
		}
		switch (tiposHab.getSelectedItem().toString()) {
		case "Simple":
			t += numHabitaciones * 50;
			break;
		case "Doble":
			t += numHabitaciones * 75;
			break;
		case "Suite":
			t += numHabitaciones * 125;
			break;
		}

		lTotal.setText("Importe Total : " + t + "�");
	}

	/**
	 * Agregamos todos los elementos al panel
	 */
	private void agregarComponentes() {
		this.add(lTiposHab);
		this.add(tiposHab);
		this.add(lnHab);
		this.add(nHab);
		this.add(ni�os);
		this.add(pNi�os);
		this.add(prev);
		this.add(next);
		this.add(imagen);
		this.add(lTotal);
	}

	/**
	 * Comprobamos el estado del panel ni�os
	 */
	private static void comprobarEstadoPanel() {
		if (ni�os.isSelected()) {
			edad.setEnabled(true);
			lCama.setText("Cama: Cuna");
			lImporteNi�o.setText("Importe Adicional: 20�");
		} else {
			edad.setEnabled(false);
			edad.setValue(new Integer(0));
			lCama.setText("Cama: Ninguna");
			lImporteNi�o.setText("Importe Adicional: 0�");
		}
	}

	/**
	 * Cambiamos de imagen cada vez que pulsemos en el boton next o prev
	 * 
	 * @param e indica el boton que ha accionado el evento
	 */
	private void cambiarImagen(ActionEvent e) {
		if (e.getSource() == next) {

			if (contador >= 3) {
				contador = 1;
			} else {
				contador++;
			}
		} else {

			if (contador <= 1) {
				contador = 3;
			} else {
				contador--;
			}
		}

		icono = new ImageIcon(getClass().getResource("/Recursos/" + contador + ".jpg"));
		imagen.setIcon(icono);

	}

	/**
	 * Establece la fuente personalizada a todos los componentes
	 */
	private static void establecerFuente() {
		for (int i = 0; i < listaC.length; i++) {
			listaC[i].setFont(fuente);
		}
	}
}
