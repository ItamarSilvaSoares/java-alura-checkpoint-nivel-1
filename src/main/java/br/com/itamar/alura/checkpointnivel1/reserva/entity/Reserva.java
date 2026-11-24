package br.com.itamar.alura.checkpointnivel1.reserva.entity;

import br.com.itamar.alura.checkpointnivel1.reserva.service.ReservaEntityValidations;
import br.com.itamar.alura.checkpointnivel1.sala.entity.Sala;
import br.com.itamar.alura.checkpointnivel1.usuario.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservas")
public class Reserva {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  // informa o início da reserva
  @Setter(AccessLevel.NONE)
  private LocalDateTime inicio;

  // informa o fim da reserva
  @Setter(AccessLevel.NONE)
  private LocalDateTime fim;

  // identifica o usuario que fez a reserva
  @OneToOne private Usuario usuario;

  //  identifica qual sala a reserva pertence
  @OneToOne private Sala sala;

  @Enumerated(EnumType.STRING)
  private ReservationStatus status;

  public void setInicio(LocalDateTime inicio) {
    this.inicio = ReservaEntityValidations.setInicio(inicio);
  }

  public void setFim(LocalDateTime fim) {
    this.fim = ReservaEntityValidations.setFim(fim, this.inicio);
  }
}
