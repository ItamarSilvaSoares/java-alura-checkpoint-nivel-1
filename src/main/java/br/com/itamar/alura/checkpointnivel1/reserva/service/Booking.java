package br.com.itamar.alura.checkpointnivel1.reserva.service;

import br.com.itamar.alura.checkpointnivel1.reserva.dto.ReservationOrder;
import br.com.itamar.alura.checkpointnivel1.reserva.entity.ReservationStatus;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;
import java.time.LocalDateTime;

public class Booking {
  public static boolean checkOrder(ReservationOrder order) {
    if (order.amount() <= 0) {
      return false;
    }

    LocalDateTime startDate = ConvertDate.converterData(order.startDate());
    LocalDateTime endDate = ConvertDate.converterData(order.endDate());

    return !startDate.isBefore(endDate);
  }

  public static boolean checkRoom(Sala room, ReservationOrder order) {
    if (!room.isAtivo()) {
      return false;
    }

    if (room.isReservado()) {
      LocalDateTime startDateOrder = ConvertDate.converterData(order.startDate());

      LocalDateTime endDateRoom = room.getReserva().getFim();

      return !startDateOrder.isBefore(endDateRoom)
          || room.getReserva().getStatus() == ReservationStatus.CANCELADA;
    }

    return room.getCapacidade() < order.amount();
  }
}
