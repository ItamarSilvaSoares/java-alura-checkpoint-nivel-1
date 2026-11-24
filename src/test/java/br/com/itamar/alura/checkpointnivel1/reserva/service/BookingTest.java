package br.com.itamar.alura.checkpointnivel1.reserva.service;

import br.com.itamar.alura.checkpointnivel1.reserva.dto.ReservationOrder;
import br.com.itamar.alura.checkpointnivel1.reserva.entity.Reserva;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class BookingTest {

  @Test
  void checkOrder() {}

  @Test
  void checkRoom() {
    Sala sala = new Sala();
    sala.setAtivo(true);
    sala.setCapacidade(50);
    sala.setIsReservado(true);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    reserva.setInicio(LocalDateTime.parse("24/11/2026 12:30:00", formatter));
    reserva.setFim(LocalDateTime.parse("24/11/2026 14:30:00", formatter));
    sala.setReserva(reserva);

    ReservationOrder order = new ReservationOrder(50, "24/11/2026 14:30:00", "24/11/2026 15:30:00");
    assert Booking.checkRoom(sala, order);
  }
}
