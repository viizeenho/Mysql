package com.game.LojaGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.LojaGame.model.Jogo;

@Repository
public interface jogoRepository extends JpaRepository<Jogo, Long> {
	public List<Jogo> findAllByNomeContainingIgnoreCase(String nome);
}
