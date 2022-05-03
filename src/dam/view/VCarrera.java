package dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import dam.control.ControlCorredores;

import javax.swing.JSeparator;

public class VCarrera extends JFrame {
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	public static final String MNTN_INTRODUCIR = "Introducir";
	public static final String MNTN_CONSULTAR = "Consultar corredor";
	public static final String MNTN_SALIR = "Salir";
	
	private JScrollPane scrpContenedor;
	private JMenuItem mntmIntroducir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmSalir;
	
	public VCarrera() {
		inicializarComponentes();
	}


	private void inicializarComponentes() {
		setTitle("Madrid Rock and Roll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(ANCHO, ALTO);
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		centrarVentana();
		
		crearMenu();
	}
	
	private void crearMenu() {
		JMenuBar mnbMenu = new JMenuBar();
		setJMenuBar(mnbMenu);
		
		mntmIntroducir = new JMenuItem(MNTN_INTRODUCIR);
		mntmIntroducir.setHorizontalAlignment(SwingConstants.CENTER);
		mnbMenu.add(mntmIntroducir);
		
		JSeparator separator = new JSeparator();
		mnbMenu.add(separator);
		
		mntmConsultar = new JMenuItem(MNTN_CONSULTAR);
		mntmConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		mnbMenu.add(mntmConsultar);
		
		JSeparator separator_1 = new JSeparator();
		mnbMenu.add(separator_1);
		
		mntmSalir = new JMenuItem(MNTN_SALIR);
		mntmSalir.setHorizontalAlignment(SwingConstants.CENTER);
		mnbMenu.add(mntmSalir);
	}


	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO, ALTO));     
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                  
		Dimension ventana = this.getPreferredSize();                      
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setControlador(ControlCorredores controlador) {
		mntmConsultar.addActionListener(controlador);
		mntmIntroducir.addActionListener(controlador);
		mntmSalir.addActionListener(controlador);
	}
	
}
