package colegioo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	ArrayList<Integer> list =new ArrayList<Integer>();
	ArrayList <String> listProf;
		public void Inicio() {
		System.out.println("Bienvenido");

		String menu = "Menu\n";
		menu+="1. Registrar profesores";
		menu+="2. Registrar estudiantes asociados a los profesores";
		menu+="3. Consultar";
		menu+="4. salir\n";
	}
	public void menu(int opcion) {
		switch (opcion) {
		
		case 1: {
			regsProf();
			break;
		}
		case 2: {
			if(validar()) {
				listEst();
			}
			break;
		}
		case 3: {
			consultar();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}
	public boolean validar () {
		if(listProf != null) {
			return true;
		}else {
			System.out.println("Debe llenar datos");
			return false;
		}
	}
	public void regsProf() {
		int cant = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de profesores a registrar"));
		
		for(int i=0; i < cant; i++) {
			listProf.add(JOptionPane.showInputDialog("Ingrese el nombre del profesor"));
		}
	}
	public void listEst() {
		
	}
	public void consultar() {
		
	}
}
