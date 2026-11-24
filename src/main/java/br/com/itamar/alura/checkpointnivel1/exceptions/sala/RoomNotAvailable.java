package br.com.itamar.alura.checkpointnivel1.exceptions.sala;

public class RoomNotAvailable extends RuntimeException {
  public RoomNotAvailable() {
    String msg = "Sala não disponível";

    super(msg);
  }
}
