package br.com.project.checkskills.repositories.matriz;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.matriz.AvaliacaoEntity;

public interface IAvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {

}
