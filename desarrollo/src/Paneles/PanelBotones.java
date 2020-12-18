/**
 * 
 */
package Paneles;

import java.awt.Color;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase PanelBotones
 * 
 * Representa el panel que contiene los tres botones:
 * <ul>
 * <li>Imprimir</li>
 * <li>Nuevo</li>
 * <li>Guardar</li>
 * 
 * @author Jose Manuel Cruzado Lorente
 *
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

	/**
	 * Botones imprimir, nuevo y guardar
	 */
	private static JButton imprimir, nuevo, guardar;

	/**
	 * Variable para tratar con ImageIcon
	 */
	private static ImageIcon icono;

	/**
	 * Constructor sin parametros para instanciar el panel
	 */
	public PanelBotones() {
		this.setLayout(null);

		nuevo = new JButton("Nuevo Documento");
		imprimir = new JButton();
		guardar = new JButton("Guardar Documento");

		imprimir.setBounds(400, 50, 150, 150);
		nuevo.setBounds(800, 50, 150, 150);
		guardar.setBounds(1200, 50, 150, 150);

		setIconos();

		imprimir.addActionListener(e -> {
			imprimirDatos();
		});
		nuevo.addActionListener(e -> {
			resetear();
		});
		guardar.addActionListener(e -> {
			this.guardar();
		});
		this.add(nuevo);
		this.add(imprimir);
		this.add(guardar);

		this.setBackground(new Color(37, 181, 194, 200));

		this.setVisible(true);
	}

	/**
	 * Añade los iconos a los tres botones.
	 */
	private void setIconos() {
		icono = new ImageIcon(getClass().getResource("/Recursos/imprimir.png"));
		imprimir.setIcon(icono);
		icono = new ImageIcon(getClass().getResource("/Recursos/new.png"));
		nuevo.setIcon(icono);
		icono = new ImageIcon(getClass().getResource("/Recursos/save.png"));
		guardar.setIcon(icono);

	}

	/**
	 * Imprime todos los datos tanto del cliente como de la habitacion.
	 */
	private static void imprimirDatos() {

		String datosC = "<html><center><h2>Datos del Cliente</h2></center>";
		datosC += "<b>Nombre</b>: " + PanelFormulario.nombre.getText() + "<br>";
		datosC += "<b>Apellidos</b>:" + PanelFormulario.apellidos.getText() + "<br>";
		datosC += "<b>DNI</b>:" + PanelFormulario.dni.getText() + "<br>";
		datosC += "<b>Telefono</b>:" + PanelFormulario.telefono.getText() + "<br>";
		datosC += "<b>Dias Total en la Estancia</b>: " + PanelFormulario.lTotalDias.getText() + "<br></html>";

		PanelDatos.jt1.setText(datosC);

		String datosH = "<html><center><h2>Datos de la Habitación</h2></center>";
		datosH += "<b>Tipo de Habitación seleccionada: </b>" + PanelHabs.tiposHab.getSelectedItem().toString() + "<br>";
		datosH += "<b>Numero de Habitaciones seleccionadas: </b>" + PanelHabs.nHab.getValue().toString() + "<br>";

		if (PanelHabs.niños.isSelected()) {
			datosH += "<b>--- Habitacion extra para niño: ---</b><br>";
			datosH += "<b>" + PanelHabs.lCama.getText() + ", Niño de: " + PanelHabs.edad.getValue().toString()
					+ " años.</b><br>";
		}
		datosH += "<b>" + PanelHabs.lTotal.getText() + "</b>";

		PanelDatos.jt2.setText(datosH);

	}

	/**
	 * Resetear todos los datos
	 */
	private static void resetear() {
		Date temporal = new Date();
		Date mañana = new Date(temporal.getTime() + 86400000);

		PanelFormulario.nombre.setText("");
		PanelFormulario.nombre.requestFocus();
		PanelFormulario.apellidos.setText("");

		PanelFormulario.dni.setValue(null);
		PanelFormulario.telefono.setValue(null);

		PanelFormulario.lTotalDias.setText("0");
		PanelFormulario.fechaSalida.setValue(mañana);
		PanelFormulario.fechaInicio.setValue(temporal);

		PanelHabs.tiposHab.setSelectedIndex(0);
		PanelHabs.nHab.setValue(0);
		PanelHabs.niños.setSelected(false);
		PanelHabs.lCama.setText("Cama: Ninguna");
		PanelHabs.edad.setValue(0);
		PanelHabs.lImporteNiño.setText("Importe Adicional: 0€");

		PanelDatos.jt1.setText("");
		PanelDatos.jt2.setText("");
	}

	/**
	 * Muestra un mensaje para simular un guardado.
	 */
	private void guardar() {
		JOptionPane.showMessageDialog(this, "¡Ha guardado con éxito los datos de su reserva!", "Guardado.",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
