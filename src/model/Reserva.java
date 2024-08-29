package src.model;

import java.time.LocalDate;

public class Reserva {
   private Exemplar exemplar;
   private Usuario usuario;
   private LocalDate dataReserva;

    public Reserva(Exemplar exemplar, Usuario usuario) {
         this.exemplar = exemplar;
         this.usuario = usuario;
         this.dataReserva = LocalDate.now();
    }

    public Exemplar getExemplar() {
         return exemplar;
    }

    public Usuario getUsuario() {
         return usuario;
    }

    public LocalDate getDataReserva() {
         return dataReserva;
    }

}
