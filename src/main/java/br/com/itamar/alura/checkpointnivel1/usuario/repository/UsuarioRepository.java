package br.com.itamar.alura.checkpointnivel1.usuario.repository;

import br.com.itamar.alura.checkpointnivel1.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
