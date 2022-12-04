import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Vector<Encargado> asistances = new Vector();
        //Cargando Datos
        try {
        	asistances = AdministracionDeCuentas.CargarDatos();
        }
        catch(Exception ex) {
        	System.out.println("No se encuentran datos");
        }
        //Opciones para el usuario
    	String option = "";
        while(true) {
        	try {
            	Opciones();
        		option = scan.next();
        		if(RevisarOption(option)==true) {
        		switch(option) {
        			//Mostrar listado
        			case "1":
        				ObtenerListado(asistances);
        			break;
        			//A–adir nuevo encargado
        			case "2":
        				System.out.println("-------------------------------------------------");
        				System.out.println("Por favor introduzca los datos del nuevo encargado en este orden");
        				System.out.println("Nombre -> Apellidos -> CI ->Edad");
        		        String name = scan.next();
        		        String apellido = scan.next();
        		        String CI = scan.next();
        		        String edadtemp = scan.next();
        		        int edad = Integer.valueOf(edadtemp);
        		        
        		        Encargado k = new Encargado(name,apellido,CI,edad);
        		        asistances.add(k);
        			break;
        			//Eliminar un encargado
        			case "3":
        				System.out.println("-------------------------------------------------");
        				System.out.println("Por favor introduzca el numero del encargado que quiere eliminar");
        				ObtenerListado(asistances);
        				String eliminartemp = scan.next();
        				int eleminar = Integer.valueOf(eliminartemp);
        				asistances.remove(eleminar-1);
        			break;
        			//Guardar Datos
        			case "4":
        		    	AdministracionDeCuentas.GuardarDatos(asistances);
        				System.out.println("-------------------------------------------------");
        				System.out.println("!Guardado con exito!");
        			break;
        			//Finalizar aplicacion
        			case "5":
        				return;
        		}
        		}
        	}
        	catch(NumberFormatException ex1){
        		System.out.println("Ha escrito una letra en lugar de un numero");
        	}
        	catch(Exception ex) {
        		System.out.println(ex.getMessage());
        	}

        }
	}
	//Opciones a mostrar
	public static void Opciones() {
		System.out.println("-------------------------------------------------");
		System.out.println("Por favor escriba el numero de la opcion deseada:");
		System.out.println("1-Mostrar listado.");
		System.out.println("2-Inscribir nuevo encargado.");
		System.out.println("3-Eliminar un encargado.");
		System.out.println("4-Guardar datos.");
		System.out.println("5-Cerrar aplicacion.");
	}
	
	//Mostrar listado
	public static void ObtenerListado(Vector<Encargados> asistances) {
		System.out.println("-------------------------------------------------");
		System.out.println("Listado de encargados al evento");
		System.out.println("#-Nombre_Apellidos_CI_Edad");
        for(int i =0;i<asistances.size();i++) {
        	System.out.println((i+1)+"-"+asistances.get(i).name+" "+asistances.get(i).lastname+
        			" "+asistances.get(i).CI+" "+asistances.get(i).edad);
        }
	}
	//Revisar q la opcion sea valida en el rango de opciones
	public static boolean RevisarOption(String k) {
		if(Integer.valueOf(k)>=1&&Integer.valueOf(k)<=5) {
			return true;
		}
		else {
			throw new InputMismatchException("La opcion es incorrecta");
		}
	}
}
