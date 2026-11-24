package br.com.itamar.alura.checkpointnivel1.reserva.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertDate {
  public static LocalDateTime converterData(String data) {
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    return LocalDateTime.parse(data, formatter);
  }
}
