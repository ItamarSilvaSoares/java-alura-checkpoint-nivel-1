package br.com.itamar.alura.checkpointnivel1.sala.entity;

import br.com.itamar.alura.checkpointnivel1.reserva.entity.Reserva;
import br.com.itamar.alura.checkpointnivel1.sala.service.SalaEntityValidations;
import br.com.itamar.alura.checkpointnivel1.usuario.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "salas")
public class Sala {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  //  informa capacidade de uma sala
  @Setter(AccessLevel.NONE)
  private int capacidade;

  //  informa se a sala está ativa;
  private boolean isAtivo;

  //  informa se uma sala está reservado
  @Setter(AccessLevel.NONE)
  private boolean isReservado = false;

  //  informa qual usuario reservou a sala
  @OneToOne private Usuario usuario;

  //  informa qual reserva se corresponde a sala
  @OneToOne private Reserva reserva;

  public void setCapacidade(int capacidade) {
    this.capacidade = SalaEntityValidations.setCapacity(capacidade);
  }

  public void setIsReservado(boolean estaReservado) {
    this.isReservado = SalaEntityValidations.setIsReservado(estaReservado, this);
  }
}
