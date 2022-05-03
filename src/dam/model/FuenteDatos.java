package dam.model;

import java.util.ArrayList;

public class FuenteDatos {
	private ArrayList<Corredor> coleccionCorredores;
	

	public FuenteDatos() {
		coleccionCorredores = new ArrayList<Corredor>();
	}


	public ArrayList<Corredor> getColeccionCorredores() {
		return coleccionCorredores;
	}
	
	
	public void nuevoCorredor(Corredor corredor) {
		coleccionCorredores.add(corredor);
	}
	
	
	public ArrayList<Corredor> getCorredoresFiltro(String sexo) {
		ArrayList<Corredor> listaFiltro = new ArrayList<Corredor>();
		
		for (Corredor corredor : coleccionCorredores) {
			if (corredor.getSexo().equals(sexo)) {
				listaFiltro.add(corredor);
			}
		}
		return listaFiltro;
	}
}
