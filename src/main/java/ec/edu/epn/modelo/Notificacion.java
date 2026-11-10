package ec.edu.epn.modelo;

public class Notificacion {
    private String destinatario;
    private String mensaje;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }


    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //Comportamiento por defecto, si alguna subclase lo necesita lo puede sobreescribir
    //para enviarlo a su manera
    public String enviar(){
        return "Notificacion para: "+destinatario+ ": "+mensaje;
    }

    //Costo por defecto es 0.0
    //Si una subclase no lo sobreescribe, se usara este valor heredado
    public double calcularCosto(){
        return 0.0;
    }

    //Crear la notificacion
    //Devuelve el tipo general Notificacion, las subclases podria sobreescribir
    //devolviendo su propio tipo(mas específico): retorno covariante.
    public Notificacion reenviar(String nuevoDestinatario){
        return new Notificacion(nuevoDestinatario, mensaje);
    }


}
