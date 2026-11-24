package br.com.itamar.alura.checkpointnivel1.exceptions.sala;

public class RoomAlreadyOccupied extends RuntimeException {
  public RoomAlreadyOccupied() {
    String msg = "Sala já ocupada";
    super(msg);
  }
}
