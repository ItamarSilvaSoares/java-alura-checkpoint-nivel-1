package br.com.itamar.alura.checkpointnivel1.exceptions.sala;

public class InvalidCapacity extends RuntimeException {
  public InvalidCapacity(int capacidade) {
    String msg = "A capacidade %d fornecida para sala é invalida.".formatted(capacidade);

    super(msg);
  }
}
