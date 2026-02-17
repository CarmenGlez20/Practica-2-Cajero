package Controllers;
import java.util.ArrayList;
import java.util.List;

import Models.Usuario;

public class CajeroController {
    // Uso de Estructuras de Datos y Genéricos (List<Usuario>)
    private List<Usuario> listaUsuarios;
    private Usuario usuarioSesion;

    public CajeroController() {
        listaUsuarios = new ArrayList<>();
        // Inicializamos datos (simulando una base de datos)
        listaUsuarios.add(new Usuario("1234", "Juan", 1000.0));
        listaUsuarios.add(new Usuario("5678", "Maria", 2500.0));
    }

    public boolean autenticar(String pin) {
        for (Usuario u : listaUsuarios) {
            if (u.getPin().equals(pin)) {
                this.usuarioSesion = u;
                return true;
            }
        }
        return false;
    }

    public double consultarSaldo() {
        return usuarioSesion.getSaldo();
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= usuarioSesion.getSaldo()) {
            usuarioSesion.setSaldo(usuarioSesion.getSaldo() - cantidad);
            return true;
        }
        return false;
    }

    public void depositar(double cantidad) {
        usuarioSesion.setSaldo(usuarioSesion.getSaldo() + cantidad);
    }

    public String getNombreUsuario() {
        return usuarioSesion.getNombre();
    }
}