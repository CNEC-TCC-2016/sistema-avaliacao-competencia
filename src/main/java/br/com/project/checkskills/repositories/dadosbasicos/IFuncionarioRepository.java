package br.com.project.checkskills.repositories.dadosbasicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;
import br.com.project.checkskills.entities.dadosbasicos.DepartamentoEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;

@Repository(value="funcionarioRepository")
public interface IFuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{
//	
//	SELECT * 
//	FROM tb_funcionario,tb_cargo,tb_departamento 
//	where (tb_funcionario.ID_CARGO = tb_cargo.ID_CARGO) 
//		and (tb_cargo.ID_DEPARTAMENTO = tb_departamento.ID_DEPARTAMENTO or tb_cargo.ID_DEPARTAMENTO = tb_departamento.ID_DEPARTAMENTO_PAI);
	
	@Query("select f  from FuncionarioEntity  f, CargoEntity c, DepartamentoEntity d "
			+ "where f.cargo.departamento.id = :departamento"
			+ " and c.departamento.id = :departamento"
			+ " and d.id = :departamento")
	public List<FuncionarioEntity> procuraEmDepartamentos(
			@Param("departamento") Long departamento);


}
