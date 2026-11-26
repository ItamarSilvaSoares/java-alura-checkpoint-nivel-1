package br.com.itamar.alura.checkpointnivel1.reserva.service;

import static org.assertj.core.api.Assertions.*;

import br.com.itamar.alura.checkpointnivel1.reserva.dto.ReservationOrder;
import br.com.itamar.alura.checkpointnivel1.reserva.entity.Reserva;
import br.com.itamar.alura.checkpointnivel1.reserva.entity.ReservationStatus;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;
import br.com.itamar.alura.checkpointnivel1.sala.service.RoomStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookingTest {

  @Test
  @DisplayName("Should return false when an invalid date is passed")
  void checkOrder() {
    LocalDateTime horarioInicio = getDateInicio("");
    ReservationOrder order = new ReservationOrder(50, horarioInicio.plusHours(2), horarioInicio);

    assertThat(Booking.checkOrder(order)).isFalse();
  }

  @Test
  @DisplayName(
      "Should return ROOM_AVAILABLE when booking a room with same time that a previous booking time is over")
  void checkRoom() {
    Sala sala = new Sala();
    sala.setAtivo(true);
    sala.setCapacidade(50);
    sala.setIsReservado(true);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);

    LocalDateTime horarioInicio = getDateInicio("");
    LocalDateTime horarioFim = horarioInicio.plusHours(2);

    reserva.setInicio(horarioInicio);
    reserva.setFim(horarioFim);
    sala.setReserva(reserva);

    ReservationOrder order = new ReservationOrder(50, horarioFim, horarioFim.plusHours(2));
    assertThat(Booking.checkRoom(sala, order)).isEqualTo(RoomStatus.ROOM_AVAILABLE);
  }

  @Test
  @DisplayName(
      "Should return ROOM_AVAILABLE when booking a room with same time that a previous booking is canceled")
  void checkRoomIfBookingWasCanceled() {
    Sala sala = new Sala();
    sala.setAtivo(true);
    sala.setCapacidade(50);
    sala.setIsReservado(true);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);
    reserva.setStatus(ReservationStatus.CANCELADA);

    LocalDateTime horarioInicio = getDateInicio("");
    LocalDateTime horarioFim = horarioInicio.plusHours(2);

    reserva.setInicio(horarioInicio);
    reserva.setFim(horarioFim);
    sala.setReserva(reserva);

    ReservationOrder order = new ReservationOrder(50, horarioInicio, horarioFim);
    assertThat(Booking.checkRoom(sala, order)).isEqualTo(RoomStatus.ROOM_AVAILABLE);
  }

  @Test
  @DisplayName(
      "Should return ROOM_OCCUPIED when booking a room with same time that a previous booking is active")
  void checkRoomIfBookingIsActivated() {
    Sala sala = new Sala();
    sala.setAtivo(true);
    sala.setCapacidade(50);
    sala.setIsReservado(true);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);
    reserva.setStatus(ReservationStatus.ATIVA);

    LocalDateTime horarioInicio = getDateInicio("");
    LocalDateTime horarioFim = horarioInicio.plusHours(2);

    reserva.setInicio(horarioInicio);
    reserva.setFim(horarioFim);
    sala.setReserva(reserva);

    ReservationOrder order = new ReservationOrder(50, horarioInicio, horarioFim);
    assertThat(Booking.checkRoom(sala, order)).isEqualTo(RoomStatus.ROOM_OCCUPIED);
  }

  @Test
  @DisplayName("Should return ROOM_UNDERSIZED when booking a room with inferior capacity necessary")
  void checkRoomCapacity() {
    Sala sala = new Sala();
    sala.setAtivo(true);
    sala.setCapacidade(50);
    sala.setIsReservado(true);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);

    LocalDateTime horarioInicio = getDateInicio("");
    LocalDateTime horarioFim = horarioInicio.plusHours(2);

    reserva.setInicio(horarioInicio);
    reserva.setFim(horarioFim);
    sala.setReserva(reserva);

    ReservationOrder order = new ReservationOrder(150, horarioInicio, horarioFim);
    assertThat(Booking.checkRoom(sala, order)).isEqualTo(RoomStatus.ROOM_UNDERSIZED);
  }

  @Test
  @DisplayName("Should return ROOM_NOT_ATIVE False when booking a room is not active")
  void checkRoomIfNotAvailability() {
    Sala sala = new Sala();
    sala.setAtivo(false);
    sala.setCapacidade(50);
    Reserva reserva = new Reserva();
    reserva.setSala(sala);

    reserva.setInicio(getDateInicio(""));
    reserva.setFim(getDateInicio("").plusHours(2));
    sala.setReserva(reserva);

    ReservationOrder order =
        new ReservationOrder(
            50, getDateInicio("24/11/2026 14:30:00"), getDateInicio("24/11/2026 15:30:00"));
    assertThat(Booking.checkRoom(sala, order)).isEqualTo(RoomStatus.ROOM_NOT_ATIVE);
  }

  private LocalDateTime getDateInicio(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    if (data.isBlank()) {
      LocalDateTime dataInicio = LocalDateTime.now().plusDays(5);
      return LocalDateTime.parse(dataInicio.format(formatter), formatter);
    }

    return LocalDateTime.parse(data, formatter).plusDays(5);
  }
}
