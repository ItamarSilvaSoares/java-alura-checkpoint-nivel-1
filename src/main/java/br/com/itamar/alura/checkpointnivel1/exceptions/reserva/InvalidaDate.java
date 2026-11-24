package br.com.itamar.alura.checkpointnivel1.exceptions.reserva;

public class InvalidaDate extends RuntimeException {
  public InvalidaDate() {
    String msg = "Data fornecida para reservar uma sala é invalida";

    super(msg);
  }
}
