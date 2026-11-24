package br.com.itamar.alura.checkpointnivel1.sala.service;

import br.com.itamar.alura.checkpointnivel1.exceptions.sala.InvalidCapacity;
import br.com.itamar.alura.checkpointnivel1.exceptions.sala.RoomAlreadyOccupied;
import br.com.itamar.alura.checkpointnivel1.exceptions.sala.RoomNotAvailable;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;

public class SalaEntityValidations {
  public static int setCapacity(int capacidade) {
    if (capacidade <= 0) {
      throw new InvalidCapacity(capacidade);
    }

    return capacidade;
  }

  public static boolean setIsReservado(boolean estaReservado, Sala sala) {
    if (!sala.isAtivo()) {
      throw new RoomNotAvailable();
    }

    if (sala.isReservado()) {
      throw new RoomAlreadyOccupied();
    }

    return estaReservado;
  }
}
