package br.com.itamar.alura.checkpointnivel1.reserva.repository;

import br.com.itamar.alura.checkpointnivel1.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
