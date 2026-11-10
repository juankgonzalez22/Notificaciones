package ec.edu.epn.modelo;

public class Notificacionsms extends Notificacion{

    public Notificacionsms(String destinatario, String mensaje) {
        super(destinatario, mensaje); //obligatorio poner super, porque el padre no tiene constructor vacio
    }

    @Override
    public String enviar() {
        return "SMS a: "+getDestinatario()+ ":"+getMensaje();
    }

    @Override
    public double calcularCosto() {
        return 0.50;
    }

    @Override
    public Notificacionsms reenviar(String nuevoDestinatario) {
        return new Notificacionsms(nuevoDestinatario,getMensaje());
    }
}
