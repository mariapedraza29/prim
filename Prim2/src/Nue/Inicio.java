package Nue;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Inicio {
		ArrayList <String> nombres;
		ArrayList <Integer> edades;
		
		public Inicio () {
			edades = new ArrayList <Integer>();
			nombres = new ArrayList <String>();
		}
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
			ArrayList<String> listTem;
			int tam=Integer.parseInt(JOptionPane.showInputDialog
					("Ingrese la cantidad de estudiantes"));
			String nomEst= "";
			int edadEst=0;
			
			for(int i=0; i<tam; i++) {
				nomEst=JOptionPane.showInputDialog("Ingrese el nombre");
				nombres.add(nomEst);
			}
			for(int j=0; j<tam; j++) {
				edadEst=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad"));
				edades.add(edadEst);
			}
		}
			public void ImprimirDatos() {
				System.out.println("Imprimir info, arreglo="+nombres);
				
				for (int i = 0; i < nombres.size(); i++) {
					System.out.println("El estudiante: " + nombres.get(i)+ " de "+ edades.get(i)+ " anios "+"esta ingresado.");
				}
				System.out.println();
		}
		public void BuscarPorNombre() {
			int cont=0;
			
			String nombreBuscar = JOptionPane.showInputDialog
					("Ingrese el nombre a buscar");
			
			for (int i = 0; i<nombres.size(); i++) {
				if(nombres.equals((nombreBuscar))) {
					JOptionPane.showMessageDialog(null, "Se encuentró"
							+ " a "+nombreBuscar+": "+edades.get(i));
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
		public void PromEdades(){
			double promE =0,res=0;
			
			for (int i = 0; i < edades.size(); i++) {
				promE+=edades.get(i);
				res= promE/edades.size();
				if(res>0 && res <18) {
					JOptionPane.showMessageDialog(null,"el promedio de estudiantes menores es superior: "+res);
					break;
				}else if(res >18){
					JOptionPane.showMessageDialog(null,"el promedio de estudiantes mayores es superior: "+res);
					break;
				}
			}
		}public void EdadMax() {
			int contMax =0,pos=0;
			String nombre="";
			contMax=edades.get(0);
			nombre=nombres.get(0);
			
			for(int i =0; i<edades.size() && i<nombres.size(); i++) {
				if (edades.get(i)>contMax) {
					contMax=edades.get(i);
				}
			for(int j=0; j>nombres.size(); i++) {
			}
			}JOptionPane.showMessageDialog(null, "Valor maximo: \n"+ contMax+ " " +nombre);
		}
		
		public void EdadMin() {
			int contMin =0,pos=0;
			String nombre="";
			contMin=edades.get(0);
			nombre=nombres.get(0);
			
			for(int i =0; i<edades.size() && i < nombres.size(); i++) {
				if (edades.get(i)<contMin) {
					contMin=edades.get(i);
				pos=i; 
				}
			}JOptionPane.showMessageDialog(null, "Valor mínimo: \n"+ contMin+ " " +nombre);
		}
		public void Mayores() {
			int cont =0;
			for(int i =0; i<edades.size(); i++) {
				if(edades.get(i)>=18) {
					JOptionPane.showMessageDialog(null, "Los estudiantes mayores de edad son:\n" + nombres.get(i)+ " "+ edades.get(i) + " anios.");
				}
				else if(edades.get(i) <18){
					System.out.println( nombres.get(i)+ " de"+ edades.get(i)+ " anios "+ " no corresponde al rango de edad\n");;
				}
			}
		}

}
