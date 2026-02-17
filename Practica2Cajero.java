package Main;
import Views.CajeroView;

public class Practica2Cajero {
    public static void main(String[] args) {
        // 1. Creamos el objeto de la Vista
        CajeroView vista = new CajeroView();
        
        // 2. Iniciamos la aplicación
        // Internamente, la Vista llamará al Controlador 
        // y el Controlador gestionará los Modelos.
        vista.iniciar();
    }
}