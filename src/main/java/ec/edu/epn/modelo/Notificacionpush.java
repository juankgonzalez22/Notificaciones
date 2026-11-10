package ec.edu.epn.modelo;

//Agregamos el nombre de la app que muestra la notificacion en el celular
public class Notificacionpush extends Notificacion{

    //atributo propio de esta clase
    private String nombreApp;

    public Notificacionpush(String destinatario, String mensaje, String nombreApp) {
        super(destinatario, mensaje);
        this.nombreApp = nombreApp;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    //Sobreescritura: La notificacion push muestra el nombre de al app
    @Override
    public String enviar() {
        return "[ "+nombreApp+" ]" + getMensaje();
    }
    //Sobrrescritura, tiene un costo distinto al padre
    @Override
    public double calcularCosto() {
        return 0.25;
    }

    @Override
    public Notificacionpush reenviar(String nuevoDestinatario) {
        return new Notificacionpush(nuevoDestinatario, getMensaje(),getNombreApp());
    }
}
