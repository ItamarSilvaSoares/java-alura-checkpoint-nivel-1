package br.com.itamar.alura.checkpointnivel1.reserva.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record ReservationOrder(
    @Positive @NotBlank(message = "A capacidade da sala é obrigatória") int amount,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @NotBlank(message = "A data é obrigatória")
        @FutureOrPresent
        LocalDateTime startDate,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") @NotBlank(message = "A data é obrigatória") @Future
        LocalDateTime endDate) {}
