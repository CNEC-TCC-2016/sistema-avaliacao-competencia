package br.com.project.checkskills.repositories.dadosbasicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;

@Repository(value="funcionarioRepository")
public interface IFuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{

}
