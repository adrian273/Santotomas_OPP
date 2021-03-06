package negocio;
import datos.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Adrian Verdugo
 * @version 0.5
 * @since 11-12-2017
 */

public class Vuelo {
    
    private Avion avion;
    private final HashMap<String, Pasajero> data_pasajero;
    private final HashMap<String, Azafata> data_azafata;
    private final HashMap<String, Piloto> data_piloto;
    static Scanner input = new Scanner(System.in);;
    
    private String rut, nombre, apellido;
    private int edad;
    
    private Servicio servicio;
    /**
     * 
     * @param avion Clase Avion
     */
    public Vuelo(Avion avion, Servicio servicio) {
        this.avion = avion;
        this.servicio = servicio;
        this.data_pasajero = new HashMap<>();
        this.data_azafata = new HashMap<>();
        this.data_piloto = new HashMap<>();
    }
    
    public Vuelo() {
        this.data_pasajero = new HashMap<>();
        this.data_azafata = new HashMap<>();
        this.data_piloto = new HashMap<>();
    }
    
    /**
     * 
     * @return Datos del avion 
     */
    public Avion getAvion() {
        return avion;
    }
    
    /**
     * 
     * @param avion Datos del avion
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    /**
     * 
     * @return servicios de entretencion
     */
    public Servicio getServicio() {
        return servicio;
    }
    
    /**
     * 
     * @param servicio de entrentencion
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
    
    /**
     * @info Agregar nuevos pasajeros.
     */
    public void addPasajero() {
        System.out.println(">>> Agregar Pasajeros");
        System.out.println("----------------------");
        System.out.println(">> Rut:");
        this.rut = input.next();
        if(data_pasajero.containsKey(this.rut)) {
            System.out.println("[ERROR] > ya registrado");
        }
        else {
            System.out.println(">> Nombre:");
            this.nombre = input.next();
            System.out.println(">> Apellido:");
            this.apellido = input.next();
            System.out.println(">> Edad:");
            this.edad = input.nextInt();
            System.out.println(">>> Agregar Pasaje [SI-si / NO-no]");
            String question = input.next();
            Boolean answer;
            switch(question) {
                case "SI" :
                    answer = true;
                    break;
                case "si" :
                    answer = true;
                    break;
                case "NO" :
                    answer = false;
                    break;
                case "no":
                    answer = false;
                    break;
                default :
                    answer = false;
                    break;
            }
            System.out.println("...................");
            Pasaje pa = pasajero_pasaje(answer);
            Pasajero pasajero = new Pasajero(pa, this.rut, this.nombre, this.apellido, this.edad);
            data_pasajero.put(rut, pasajero);
            System.out.println("[SUCESS] > agregado correctamente");
        }
           
    }
    
    /**
     * 
     * @param addPasaje [true or false]
     * @return CLASS : pasaje
     */
    public Pasaje pasajero_pasaje (Boolean addPasaje) {
        if(addPasaje)  {
            int numeroVuelo, valorPasaje;
            String fechaVuelo, horaVuelo, origenVuelo, destinoVuelo;
            System.out.println(">> Numero Vuelo:");
            numeroVuelo = input.nextInt();
            System.out.println(">> Fecha Vuelo:");
            fechaVuelo = input.next();
            System.out.println(">> Hora Vuelo:");
            horaVuelo = input.next();
            System.out.println(">> Origen Vuelo:");
            origenVuelo = input.next();
            System.out.println(">> Destino Vuelo:");
            destinoVuelo = input.next();
            System.out.println(">> Valor Pasaje:");
            valorPasaje = input.nextInt();
            tipoDeClase typeOfClass = tipoDeClase.ECONOMICO;
            Pasaje p = new Pasaje(numeroVuelo, fechaVuelo, horaVuelo, origenVuelo, destinoVuelo, typeOfClass, valorPasaje);
            System.out.println("[INFO] > Pasaje agregado");
            return p;
        } 
        else {
            Pasaje p = new Pasaje();
            System.out.println("[WARNING] > Pasaje no agregado!");
            return p;
        }
    }
    
    /**
     * @info agregar azafatas al vuelo
     */
    public void addAzafata() {
        System.out.println(">>> Agregar Azafata");
        System.out.println("----------------------");
        System.out.println(">> Rut:");
        this.rut = input.next();
        if(data_pasajero.containsKey(this.rut)) {
            System.out.println("[ERROR] > ya registrado");
        }
        else {
            System.out.println(">> Nombre:");
            this.nombre = input.next();
            System.out.println(">> Apellido:");
            this.apellido = input.next();
            System.out.println(">> Edad:");
            
            this.edad = input.nextInt();
            System.out.println(">> Nacionalidad:");
            String nacionalidad = input.next();
            String idioma = input.next();
            Azafata azafata = new Azafata(idioma, nacionalidad, this.rut, this.nombre, this.apellido, this.edad);
            this.data_azafata.put(rut, azafata);
            System.out.println("[SUCESS] > agregado correctamente");
        }
    }
    
    /**
     * @info agregar pilotos del vuelo
     */
    public void addPiloto() {
        System.out.println(">>> Agregar Piloto");
        System.out.println("----------------------");
        System.out.println(">> Rut:");
        this.rut = input.next();
        if(data_pasajero.containsKey(this.rut)) {
            System.out.println("[ERROR] > ya registrado");
        }
        else {
            System.out.println(">> Nombre:");
            this.nombre = input.next();
            System.out.println(">> Apellido:");
            this.apellido = input.next();
            System.out.println(">> Edad:");
            this.edad = input.nextInt();
            System.out.println(">> Nacionalidad:");
            String nacionalidad = input.next();
            System.out.println(">> Hora de Vuelos:");
            int horaVuelo = input.nextInt();
            Piloto piloto = new Piloto(horaVuelo, nacionalidad, this.rut, this.nombre, this.apellido, this.edad);
            this.data_piloto.put(rut, piloto);
            System.out.println("[SUCESS] > agregado correctamente");
        }
    }
    
    /**
     * @info eliminacion de pasajeros
     */
    public void deletePasajero() {
        if(this.data_pasajero.isEmpty()) {
            System.out.println("[ERROR] > Lista vacia!");
        }
        else {
            System.out.println(">>> Eliminar Pasajero");
            System.out.println("----------------------");
            System.out.println(">> Rut:");
            this.rut = input.next();
            if(this.data_pasajero.containsKey(this.rut)) {
                this.data_pasajero.remove(this.rut);
                System.out.println("[SUCESS] > Eliminado correctamente");
               
            }
            else {
                System.out.println("[WARNING] > Rut no encontrado!");
            }
        }
    }
    
    
    public String print() {
        return "Marca: " + this.getAvion().getMarca() + "Modelo: " + this.getAvion().getModelo() + "Tiene juegos: " + this.getServicio().getTieneJuego() + "Tiene Audifonos: " + this.getServicio().getTieneAudifono();
    }
    
    /**
     * @info menu del vuelo
     */
    public void main() {
        boolean exit = false;
        String [] options = {"1. Agregar Tripulantes", "2. Agregar Pasajero" , "3. Eliminar Pasajero", "4. Salir"};
        
        while(!exit) {
            for(String o : options) {
                System.out.println(o);
            }
            int option = input.nextInt();
            switch(option) {
                case 1: 
                    String [] optionAddTripulante = {"1. Piloto", "2. Azafata"};
                    for(String o : optionAddTripulante)
                        System.out.println(o);
                    int op = input.nextInt();
                    switch(op) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
                
                case 2:
                    this.addPasajero();
                    break;
                case 3:
                    this.deletePasajero();
                    break;
                case 4:
                    exit = true;
                    break;
            }
            
        }
    }
    
}
