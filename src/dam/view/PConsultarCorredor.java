package dam.view;

import javax.swing.JPanel;

import dam.control.ControlCorredores;
import dam.model.Corredor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PConsultarCorredor extends JPanel {
	private static final int RESTA_ANCHO = VCarrera.ANCHO - 15;
	private static final int RESTA_ALTO = VCarrera.ALTO -70;
	public static final String BTN_CONSULTAR = "Consultar";
	public static final String HOMBRE = "Hombre";
	public static final String MUJER = "Mujer";
	public static final String AMBOS = "Ambos";
	
	private static final String COLUMN_NOMBRE = "NOMBRE";
	private static final String COLUMN_DORSAL = "DORSAL";
	private static final String COLUMN_SEXO = "SEXO";
	private static final String COLUMN_EDAD = "EDAD";
	private static final String COLUMN_MODALIDAD = "MODALIDAD";
	
	private final ButtonGroup btgFiltro = new ButtonGroup();
	private JButton btnConsultar;
	private JRadioButton rdbtnAmbos;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JScrollPane scrpTabla;
	private JTable tblCorredores;
	private DefaultTableModel dtmTablaConsulta;
	
	
	public PConsultarCorredor() {
		inicializarComponentes();
	}


	private void inicializarComponentes() {
		setLayout(null);
		setSize(RESTA_ANCHO, RESTA_ALTO);
		
		JLabel lblOpcion = new JLabel("Introduce el sexo para filtrar:");
		lblOpcion.setBounds(77, 63, 264, 14);
		add(lblOpcion);
		
		rdbtnHombre = new JRadioButton(HOMBRE);
		btgFiltro.add(rdbtnHombre);
		rdbtnHombre.setBounds(77, 121, 109, 23);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton(MUJER);
		btgFiltro.add(rdbtnMujer);
		rdbtnMujer.setBounds(279, 121, 109, 23);
		rdbtnMujer.setSelected(true);
		add(rdbtnMujer);
		
		rdbtnAmbos = new JRadioButton(AMBOS);
		btgFiltro.add(rdbtnAmbos);
		rdbtnAmbos.setBounds(527, 121, 109, 23);
		add(rdbtnAmbos);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setVisible(false);
		scrpTabla.setBounds(77, 190, 639, 247);
		add(scrpTabla);
		
		tblCorredores = new JTable();
		scrpTabla.setViewportView(tblCorredores);
		configurarTabla();
		
		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setBounds(348, 469, 100, 23);
		add(btnConsultar);
	}
	
	
	private void configurarTabla() {
		dtmTablaConsulta = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblCorredores.setModel(dtmTablaConsulta);
		
		dtmTablaConsulta.addColumn(COLUMN_NOMBRE);
		dtmTablaConsulta.addColumn(COLUMN_DORSAL);
		dtmTablaConsulta.addColumn(COLUMN_SEXO);
		dtmTablaConsulta.addColumn(COLUMN_EDAD);
		dtmTablaConsulta.addColumn(COLUMN_MODALIDAD);
		
		tblCorredores.getColumn(COLUMN_NOMBRE).setPreferredWidth(50);
		tblCorredores.getColumn(COLUMN_DORSAL).setPreferredWidth(30);
		tblCorredores.getColumn(COLUMN_SEXO).setPreferredWidth(40);
		tblCorredores.getColumn(COLUMN_EDAD).setPreferredWidth(40);
		tblCorredores.getColumn(COLUMN_MODALIDAD).setPreferredWidth(50);
	}
	
	
	public void rellenarTabla(ArrayList<Corredor> listaCorredores) {
		dtmTablaConsulta.getDataVector().clear();
		Object[] fila = new Object[5];
		
		for (Corredor corredor : listaCorredores) {
			fila[0] = corredor.getNombre();
			fila[1] = corredor.getDorsal();
			fila[2] = corredor.getSexo();
			fila[3] = corredor.getEdad();
			fila[4] = corredor.getModalidad();
			dtmTablaConsulta.addRow(fila);
		}
	}


	public void setControlador(ControlCorredores controlador) {
		btnConsultar.addActionListener(controlador);
	}


	public void hacerTabVisi(boolean b) {
		scrpTabla.setVisible(b);
	}


	public String controlSexo() {
		String sexo = "";
		
		if (rdbtnAmbos.isSelected()) {
			sexo = rdbtnAmbos.getText();
		} else if (rdbtnHombre.isSelected()) {
			sexo = rdbtnHombre.getText();
		} else if (rdbtnMujer.isSelected()) {
			sexo = rdbtnMujer.getText();
		}
		return sexo;
	}


	public void mostrarError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
