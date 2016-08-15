package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.checkskills.entities.dadosbasicos.NivelEntity;

public interface INivelRepository extends JpaRepository<NivelEntity, Long> {

	public List<NivelEntity> findByNivel(String nivel);

}
