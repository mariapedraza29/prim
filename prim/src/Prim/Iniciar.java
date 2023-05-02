package Prim;

import javax.swing.JOptionPane;

public class Iniciar {
		String nombres[];
		int edades[];
		public void iniciar() {
			JOptionPane.showMessageDialog(null, "Bienvenido");
			
			String menu = "GESTION ESTUDIANTES\n";
			menu+="1. Pedir datos del estudiante\n";
			menu+="2. Imprimir estudiantes\n";
			menu+="3. El promedio de edades\n ";
			menu+="4. Estudiante(s) con edad maxima\n";
			menu+="5. Estudiante(s) con edad minima\n";
			menu+="6. Estudiantes mayores de edad\n";
			menu+="7. Buscar por nombre\n";
			menu+="8. Salir\n";
			
			int opc=0;
			
			do {
				opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
				menu(opc);
			}while(opc!=8);
		}
		public void menu(int opcion) {
			switch (opcion) {
			case 1: {
				PedirDatos();
				break;
			}
			case 2: {
				if (ValidarLlenado()) {
					ImprimirDatos();	
				}					
				break;
			}
			case 3: {
				if (ValidarLlenado()) {
					PromEdades();
				}					
				break;
			}case 4: {
				if (ValidarLlenado()) {
					EdadMax();
				}					
				break;
			}
			case 5: {
				if (ValidarLlenado()) {
					EdadMin();
				}					
				break;
			}
			case 6: {
				if (ValidarLlenado()) {
					Mayores();
				}					
				break;
			}
			case 7: {
				if (ValidarLlenado()) {
					BuscarPorNombre();
				}					
				break;
			}
			
			case 8: System.out.println("Chao!");			
			break;
			
			
			default:System.out.println("Ingrese bien la opcion");
			break;
				
			}
			
		}
		public boolean ValidarLlenado() {
			if (nombres!=null) {
				return true;	
			}else {
				System.out.println("Debe llenar datos");
				return false;
			}
		}
		public void PedirDatos() {
			int tam=Integer.parseInt(JOptionPane.showInputDialog
					("Ingrese la cantidad de estudiantes"));
			nombres=new String [tam];
			edades=new int [tam];
			
			for(int i=0; i<nombres.length; i++) {
				nombres[i]=JOptionPane.showInputDialog("Ingrese el nombre");
			}
			for(int j=0; j<edades.length; j++) {
				edades[j]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
			}
		}
		
		public void ImprimirDatos() {
			System.out.println("Imprimir info, arreglo="+nombres);
				
			for (int i = 0; i < nombres.length; i++) {
				System.out.println("El estudiante: " + nombres[i]+ " de "+ edades[i]+ " anios "+"esta ingresado.");
			}
			System.out.println();
		}
		
		public void PromEdades(){
			double promE =0,res=0;
			
			for (int i = 0; i < edades.length; i++) {
				promE+=edades[i];
				res= promE/edades.length;
				
				if(res>0 && res <18 ) {
					JOptionPane.showMessageDialog(null,"el promedio de estudiantes menores es superior: "+res);
					break;
				}else if(res >18){
					JOptionPane.showMessageDialog(null,"el promedio de estudiantes mayores es superior: "+res);
					break;
				}
			}
		}
		
		public void EdadMax() {
			int contMax =0,pos=0;
			String nombre="";
			contMax=edades[0];
			nombre=nombres[0];
			
			for(int i =0; i<edades.length && i<nombres.length; i++) {
				if (edades[i]>contMax) {
					contMax=edades[i];
				pos=i; 
				}
			}JOptionPane.showMessageDialog(null, "Valor maximo: \n"+ contMax+ " " +nombre);
		}
		
		public void EdadMin() {
			int contMin =0,pos=0;
			String nombre="";
			contMin=edades[0];
			nombre=nombres[0];
			
			for(int i =0; i<edades.length&& i<nombres.length; i++) {
				if (edades[i]<contMin) {
					contMin=edades[i];
				pos=i; 
				}
			for(int j=0; j>nombres.length; i++) {
			}
			}JOptionPane.showMessageDialog(null, "Valor mínimo: \n"+ contMin+ " " +nombre);
		}
		
		
		
		public void BuscarPorNombre() {
			int cont=0;
			
			String nombreBuscar = JOptionPane.showInputDialog
					("Ingrese el nombre a buscar");
			
			for (int i = 0; i<nombres.length; i++) {
				if(nombres[i].equalsIgnoreCase((nombreBuscar))) {
					JOptionPane.showMessageDialog(null, "Se encuentró"
							+ " a "+nombreBuscar+": "+edades[i]);
					cont++;
				}
			}
			if (cont>0) {
				System.out.println("Encontró a "+nombreBuscar+
						" "+cont+" veces");
			}else {
				System.out.println("No encuentra a "+nombreBuscar);
			}
		}
		
		
		public void Mayores() {
			int cont =0;
			for(int i =0; i<edades.length; i++) {
					if(edades[i]>=18) {
						System.out.println( "Los estudiantes mayores de edad son:\n" + nombres[i]+ " "+ edades[i]+ " anios.");	
				}
				else if(edades[i] < 18){
					System.out.println( nombres[i]+ " de "+ edades[i]+ " anios "+ " no corresponde al rango de edad\n");
				}
			}
		}
}
