package br.com.itamar.alura.checkpointnivel1.reserva.service;

import br.com.itamar.alura.checkpointnivel1.exceptions.reserva.InvalidaDate;
import java.time.LocalDateTime;

public class ReservaEntityValidations {
  public static LocalDateTime setInicio(LocalDateTime inicio) {
    if (inicio.isBefore(LocalDateTime.now())) {
      throw new InvalidaDate();
    }

    return inicio;
  }

  public static LocalDateTime setFim(LocalDateTime fim, LocalDateTime inicio) {
    if (fim.isBefore(inicio)) {
      throw new InvalidaDate();
    }

    return fim;
  }
}
