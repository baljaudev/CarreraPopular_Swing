package dam.view;

import javax.swing.JPanel;

import dam.control.ControlCorredores;
import dam.model.Corredor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PIntroducirCorredor extends JPanel {
	
	private static final int RESTA_ANCHO = VCarrera.ANCHO - 15;
	private static final int RESTA_ALTO = VCarrera.ALTO -70;
	public static final String GUARDAR = "Guardar";
	public static final String LIMPIAR = "Limpiar";
	
	private JTextField txtNombre;
	private JTextField txtDorsal;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private final ButtonGroup btnGrupo = new ButtonGroup();
	private JSpinner spnEdad;
	private JComboBox<String> cmbModalidad;
	private JButton btnGuardar;
	private JButton btnLimiar;
	
	public PIntroducirCorredor() {
		setSize(RESTA_ANCHO, RESTA_ALTO);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(114, 33, 72, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(227, 30, 96, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setBounds(114, 112, 72, 14);
		add(lblDorsal);
		
		txtDorsal = new JTextField();
		txtDorsal.setColumns(10);
		txtDorsal.setBounds(227, 109, 96, 20);
		add(txtDorsal);
		
		rdbtnHombre = new JRadioButton("Hombre");
		btnGrupo.add(rdbtnHombre);
		rdbtnHombre.setBounds(114, 164, 109, 23);
		rdbtnHombre.setSelected(true);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		btnGrupo.add(rdbtnMujer);
		rdbtnMujer.setBounds(258, 164, 109, 23);
		add(rdbtnMujer);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(114, 234, 72, 14);
		add(lblEdad);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spnEdad.setBounds(242, 232, 65, 16);
		add(spnEdad);
		
		JLabel lblModalidad = new JLabel("Modalidad:");
		lblModalidad.setBounds(114, 315, 72, 14);
		add(lblModalidad);
		
		cmbModalidad = new JComboBox<String>();
		cmbModalidad.setBounds(227, 311, 96, 22);
		cmbModalidad.setModel(new DefaultComboBoxModel<String>(Corredor.MODALIDADES));
		add(cmbModalidad);
		
		btnGuardar = new JButton(GUARDAR);
		btnGuardar.setBounds(181, 442, 89, 23);
		add(btnGuardar);
		
		btnLimiar = new JButton(LIMPIAR);
		btnLimiar.setBounds(450, 442, 89, 23);
		add(btnLimiar);
	}
	

	public void setControlador(ControlCorredores controlador) {
		btnGuardar.addActionListener(controlador);
		btnLimiar.addActionListener(controlador);
	}


	public Corredor obtenerCorredor() {
		Corredor corredor = null;
		
		String nombre = txtNombre.getText();
		if (nombre.isBlank()) {
			mostrarError("El nombre no puede estar en blanco", "Error nombre");
		} else {
			try {
				int dorsal = Integer.valueOf(txtDorsal.getText());
				if (dorsal>9999) {
					mostrarError("No puede tener más de 5 dígitos", "Error dorsal");
				} else {
					String sexo = obtenerSexo();
					if (sexo.isBlank()) {
						mostrarError("El sexo no puede estar vacío", "Error sexo");
					} else {
						int edad = (int) spnEdad.getValue();
						String modalidad = (String) cmbModalidad.getSelectedItem();
						
						corredor = new Corredor(nombre, dorsal, sexo, edad, modalidad);
					}
				}
			} catch (NumberFormatException e) {
				mostrarError("El dorsal debe ser un número", "Error dorsal");
			}
		}
		
		return corredor;
	}


	private String obtenerSexo() {
		String sexo = "";
        if (rdbtnHombre.isSelected()) {
            sexo = rdbtnHombre.getText();
        } else if (rdbtnMujer.isSelected()) {
			sexo = rdbtnMujer.getText();
		}
        return sexo;
    }


	private void mostrarError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, 
				mensaje, 
				titulo,
				JOptionPane.ERROR_MESSAGE);
	}


	public void mostrarMensaje(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, 
				mensaje, 
				titulo,
				JOptionPane.INFORMATION_MESSAGE);
	}


	public void limpiarComponentes() {
        txtNombre.setText("");
        txtDorsal.setText("");
        rdbtnHombre.setSelected(true);
        rdbtnMujer.setSelected(false);
        spnEdad.setValue(0);
        cmbModalidad.setSelectedIndex(0);
	}
}
