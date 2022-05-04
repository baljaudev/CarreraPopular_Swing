package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dam.model.Corredor;
import dam.model.FuenteDatos;
import dam.view.PConsultarCorredor;
import dam.view.PIntroducirCorredor;
import dam.view.VCarrera;

public class ControlCorredores implements ActionListener {
	
	VCarrera ventana;
	PIntroducirCorredor pIntroducir;
	PConsultarCorredor pConsultar;
	FuenteDatos datos;

	
	public ControlCorredores(VCarrera ventana, PIntroducirCorredor pIntroducir, PConsultarCorredor pConsultar,
			FuenteDatos datos) {
		this.ventana = ventana;
		this.pIntroducir = pIntroducir;
		this.pConsultar = pConsultar;
		this.datos = datos;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals(VCarrera.MNTN_CONSULTAR)) {
				ventana.cargarPanel(pConsultar);
				pConsultar.hacerTabVisi(false);
			} else if (e.getActionCommand().equals(VCarrera.MNTN_INTRODUCIR)) {
				ventana.cargarPanel(pIntroducir);
			} else if (e.getActionCommand().equals(VCarrera.MNTN_SALIR)) {
				int resp = JOptionPane.showConfirmDialog(ventana, "Se va a cerrar la aplicación, ¿desea continuar?",
						"Confirmar salir", 
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		} else if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals(PIntroducirCorredor.GUARDAR)) {
				Corredor corredor = pIntroducir.obtenerCorredor();
				if (corredor != null) {
					datos.nuevoCorredor(corredor);
					pIntroducir.mostrarMensaje("El corredor se ha guardado correctamente", "Confirmación");
					
				}
			} else if (e.getActionCommand().equals(PIntroducirCorredor.LIMPIAR)) {
				pIntroducir.limpiarComponentes();
			} else if (e.getActionCommand().equals(PConsultarCorredor.BTN_CONSULTAR)) {
				if (datos.getColeccionCorredores().isEmpty()) {
					pConsultar.mostrarError("No hay datos que mostrar", "Error");
				} else {
					 String sexo = pConsultar.filtrarSexo();
					 if (sexo.equals("Ambos")) {
						 pConsultar.rellenarTabla(datos.getColeccionCorredores());
					} else {
						pConsultar.rellenarTabla(datos.getCorredoresFiltro(sexo));
					}
					pConsultar.hacerTabVisi(true);
				}
			}
		}
	}
}