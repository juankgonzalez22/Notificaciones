package ec.edu.epn.modelo;

public class Notificacionemail extends Notificacion {
    private String asunto;

    public Notificacionemail(String destinatario, String mensaje, String asunto) {
        //super(..) llama al constructor del padre y tiene que ir en la PRIMERA LINEA(PILAS)
        //El padre inicializa destinatario y mensaje, la clase hija se encarga del asunto
        super(destinatario, mensaje);
        this.asunto = asunto;

    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    //Sobreescritura, misma firma que el metodo enviar del padre, pero con otro compartamiento
    //Override, le dice al compuilador, que verifique que de verdad sobreescribimos
    @Override
    public String enviar() {
        return "Email a : "+getDestinatario()+ "| Asunto: "+ asunto + " | "+getMensaje();
    }

    //Retorno covariante: el padre declara que reenviar() devuelve un objeto Notificacion
    //Aqui sobreescribirmos, y declaramo un tipo mas especifico en la firma del metodo
    //NotificacionEmail, que tambien es una Notificacion


    @Override
    public Notificacionemail reenviar(String nuevoDestinatario) {
        return new Notificacionemail(nuevoDestinatario, getMensaje(),getAsunto());
    }
}
