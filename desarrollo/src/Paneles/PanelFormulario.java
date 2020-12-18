/**
 * 
 */
package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

/**
 * Clase PanelFormulario
 * 
 * Contiene lo necesario para crear el panel con los datos para rellenar el
 * formulario
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class PanelFormulario extends JPanel {

	/**
	 * Nombre del Cliente
	 */
	static JTextField nombre;
	/**
	 * Apellidos del Cliente
	 */
	static JTextField apellidos;
	/**
	 * DNI del Cliente
	 */
	static JFormattedTextField dni;
	/**
	 * Telefono del Cliente
	 */
	static JFormattedTextField telefono;
	/**
	 * Fecha de entrada del Cliente
	 */
	static JSpinner fechaInicio;
	/**
	 * Fecha de salida del Cliente
	 */
	static JSpinner fechaSalida;

	/**
	 * Etiquetas para definir cada campo
	 */
	static JLabel lNombre, lApellidos, lDni, lTelefono, lFechaI, lFechaS, lTotalDias, lDias;
	/**
	 * Mascaras para controlar las entradas de dni y telefono
	 */
	static MaskFormatter mDni, mTelefono;
	/**
	 * Spinners para las fechas
	 */
	private static SpinnerDateModel modelo, modelo2;
	/**
	 * Fuente personalizada para las etiquetas
	 */
	private static Font fuente = new Font("MV Boli", 1, 18);

	/**
	 * Lista que contiene todos los componentes
	 */
	private static JComponent listaC[];
	/**
	 * Lista con todas las etiquetas
	 */
	private static JLabel[] listaE;

	/**
	 * Constructor sin parametros
	 */
	public PanelFormulario() {

		this.setLayout(null);

		this.iniciarComponentes();
		establecerFuente();
		this.posicionarComponentes();

		this.setBackground(new Color(206, 229, 113, 200));

		this.setVisible(true);

	}

	/**
	 * Metodo para iniciar componentes del panel
	 */
	private void iniciarComponentes() {

		apellidos = new JTextField();
		nombre = new JTextField();
		nombre.requestFocus();

		try {
			mDni = new MaskFormatter("AAAAAAAAA");
			dni = new JFormattedTextField(mDni);
			dni.setFocusLostBehavior(JFormattedTextField.COMMIT);

			mTelefono = new MaskFormatter("#########");
			telefono = new JFormattedTextField(mTelefono);
			telefono.setFocusLostBehavior(JFormattedTextField.COMMIT);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Ha habido un error: " + ex.getMessage(), "Error.",
					JOptionPane.ERROR_MESSAGE);
		}

		lNombre = new JLabel("Nombre:");
		lApellidos = new JLabel("Apellidos:");
		lDni = new JLabel("DNI:");
		lTelefono = new JLabel("Telefono:");
		lFechaI = new JLabel("Fecha Inicio:");
		lFechaS = new JLabel("Fecha Salida:");
		lDias = new JLabel("Dias en la estancia");
		lTotalDias = new JLabel("1");

		Date temporal = new Date();
		Date mañana = new Date(temporal.getTime() + 86400000);

		modelo = new SpinnerDateModel();
		modelo2 = new SpinnerDateModel();

		fechaInicio = new JSpinner(modelo);
		fechaInicio.setEditor(new JSpinner.DateEditor(fechaInicio, "dd-MM-yyyy"));

		fechaSalida = new JSpinner(modelo2);
		fechaSalida.setEditor(new JSpinner.DateEditor(fechaSalida, "dd-MM-yyyy"));
		fechaSalida.setValue(mañana);

		fechaSalida.addChangeListener(e -> {
			this.cambiarTotalDias();
		});
		fechaInicio.addChangeListener(e -> {
			this.cambiarTotalDias();
		});

		listaE = new JLabel[] { lNombre, lApellidos, lDni, lTelefono, lFechaI, lFechaS, lTotalDias, lDias };
		listaC = new JComponent[] { nombre, apellidos, dni, telefono, fechaInicio, fechaSalida, lNombre, lApellidos,
				lDni, lTelefono, lFechaI, lFechaS, lTotalDias, lDias };

	}

	/**
	 * Metodo para poder posicionar los elementos
	 */
	private void posicionarComponentes() {
		lNombre.setBounds(100, 40, 100, 20);
		lApellidos.setBounds(100, 70, 100, 20);
		lFechaI.setBounds(100, 100, 200, 20);

		nombre.setBounds(310, 40, 100, 20);
		apellidos.setBounds(310, 70, 100, 20);
		fechaInicio.setBounds(310, 100, 100, 20);

		lDni.setBounds(600, 40, 100, 20);
		lTelefono.setBounds(600, 70, 100, 20);
		lFechaS.setBounds(600, 100, 200, 20);

		dni.setBounds(800, 40, 100, 20);
		telefono.setBounds(800, 70, 100, 20);
		fechaSalida.setBounds(800, 100, 100, 20);

		lDias.setBounds(1000, 40, 200, 30);
		lTotalDias.setBounds(1080, 90, 40, 20);

		/**
		 * Añadimos a la ventana todos los Componentes
		 */
		for (int i = 0; i < listaC.length; i++) {
			this.add(listaC[i]);
		}

	}

	/**
	 * Establecemos la fuente personalizada a todas las etiquetas
	 */
	private static void establecerFuente() {
		for (int i = 0; i < listaE.length; i++) {
			listaE[i].setFont(fuente);
		}
	}

	/**
	 * Cambiamos el todal de dias cada vez que cambia el spinner fecha
	 */
	private void cambiarTotalDias() {
		Date dif = new Date();
		dif.setTime(modelo2.getDate().getTime() - modelo.getDate().getTime());

		int totalDias = (int) ((((dif.getTime() / 1000) / 60) / 60) / 24);
		String dias = Integer.toString(totalDias);

		if (totalDias >= 0) {
			lTotalDias.setText(dias);
		} else {
			
			lTotalDias.setText("0");
			JOptionPane.showMessageDialog(this, "Ha usado un rango de fechas incorrecto!!!!","Error Fecha" ,JOptionPane.ERROR_MESSAGE);
		}

	}
}
