package br.com.itamar.alura.checkpointnivel1.reserva.service;

import br.com.itamar.alura.checkpointnivel1.reserva.dto.ReservationOrder;
import br.com.itamar.alura.checkpointnivel1.reserva.entity.ReservationStatus;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;
import br.com.itamar.alura.checkpointnivel1.sala.service.RoomStatus;
import java.time.LocalDateTime;

public class Booking {
  public static boolean checkOrder(ReservationOrder order) {

    return order.startDate().isBefore(order.endDate());
  }

  public static RoomStatus checkRoom(Sala room, ReservationOrder order) {
    if (!room.isAtivo()) {
      return RoomStatus.ROOM_NOT_ATIVE;
    }

    if (room.isReservado()) {
      LocalDateTime endDateRoom = room.getReserva().getFim();

      if (order.startDate().isBefore(endDateRoom)
          && room.getReserva().getStatus() == ReservationStatus.ATIVA)
        return RoomStatus.ROOM_OCCUPIED;
    }

    if (room.getCapacidade() < order.amount()) return RoomStatus.ROOM_UNDERSIZED;

    return RoomStatus.ROOM_AVAILABLE;
  }
}
