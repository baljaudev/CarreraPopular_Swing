package dam.main;

import java.awt.EventQueue;

import dam.control.ControlCorredores;
import dam.model.FuenteDatos;
import dam.view.PConsultarCorredor;
import dam.view.PIntroducirCorredor;
import dam.view.VCarrera;

public class CarreraEjecutable {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VCarrera ventana = new VCarrera();
				PIntroducirCorredor introducir = new PIntroducirCorredor();
				PConsultarCorredor consultar = new PConsultarCorredor();
				FuenteDatos datos = new FuenteDatos();
				
				ControlCorredores controlador = new ControlCorredores(ventana,introducir,consultar,datos);
				
				ventana.setControlador(controlador);
				introducir.setControlador(controlador);
				consultar.setControlador(controlador);
				
				ventana.hacerVisible();
			}
		});
	}

}
