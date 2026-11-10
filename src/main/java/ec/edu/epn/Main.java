package ec.edu.epn;

import ec.edu.epn.modelo.Notificacion;
import ec.edu.epn.modelo.Notificacionemail;
import ec.edu.epn.modelo.Notificacionpush;
import ec.edu.epn.modelo.Notificacionsms;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Crear la lista
        //La lista se declara con el tipo de la superclase(Notificacion)
        //Con eso va a aceptar los objetos de cualquier subclase que la hereda
        //porque un email, un sms y una push tambien son notificaciones
        ArrayList<Notificacion> bandeja = new ArrayList<>();

        //Agregar objetos de distintas clases a la misma lista

        bandeja.add(new Notificacion("Ana", "Su pedido fue recibido"));//pos 0
        bandeja.add(new Notificacionemail("ana@epn.edu.ec", "Su pedido esta en camino", "Pedido #001"));// pos1
        bandeja.add(new Notificacionsms("0960048580", "Su pedido ya llego"));
        bandeja.add(new Notificacionpush("Ana", "Califique su compra", "AMAZON APP"));

        // Recorrer la lista: de paso mostrar el polimorfismo

        double costoTotal = 0; //acumulador

        //En cada vuelta, la variable n es de tipo Notificacion, pero el objeto
        //al que se apunta puede ser de cualquier subclase
        //Java ejecuta el metodo del OBJETO REAL, no el del tipo de la variable
        //POLIMORFISMO DINAMICO(por sobreescritura), que se decide al ejecutar.

        for(Notificacion n : bandeja ){
            System.out.println(n.enviar() + " | Costo: $"+ n.calcularCosto());
            costoTotal += n.calcularCosto();
        }

        //size() devolver los elementos de la lista
        System.out.println("Notificaciones enviadas: "+ bandeja.size());
        System.out.println("Costo total: $"+ costoTotal);

        //Retorno covariante
        //Caso 1: La referencia es del tipo de la SUBCLASE
        //La variable email, es del tipo Notificacionemail, su reenviar() promete devolver Notificacionemail
        //asi que el resultado se guarda directamente sin necesidad de un CAST y se puede llamar a getAsunto()

        System.out.println();
        System.out.println("==Reenvios==");

        Notificacionemail email = new Notificacionemail("luis@gmail.com", "Su factura esta lista", "Factura 002");
        Notificacionemail copiaEmail = email.reenviar("contabilidad@gmail.com");
        System.out.println(copiaEmail.enviar());
        System.out.println("Asunto de la copia: "+ copiaEmail.getAsunto());

        //Caso 2: La referencia es del tipo de la SUPERCLASE
        //get(1) devuelve una referencia del tipo Notificacion. El compilador solo ve ese tipo
        // y para el reenviar() devuelve NOTIFICACION
        //Para guardar el resultado como Notificacionemail hace falta un CAST.
        //CAST funciona al ejecutar porque el objeto real es un email

        Notificacion desdeLista = bandeja.get(1);
        Notificacionemail copiaDesdeLista = (Notificacionemail) desdeLista.reenviar("soporte@gmail.com");
        System.out.println(copiaDesdeLista.enviar());
        System.out.println("Asunto de la copia: "+ copiaDesdeLista.getAsunto());

        //Caso 3: polimorfismo con reenviar()
        //La referencia es de tipo Notificacion, pero el objeto en la posicion 2 es una Notificacionsms
        //Se ejecuta reenviar() pero de Notificacionsmsm asi que la copia tambien es un sms


        Notificacion copiaSMS = bandeja.get(2).reenviar("0998133506");
        System.out.println(copiaSMS.enviar()+" | Costo:$ "+ copiaSMS.calcularCosto());


    }
}