/**
 * 
 */
package br.com.project.checkskills.repositories.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.autenticacao.PermissaoEntity;

/**
 * @author LUAN LUCAS#{permissaoRepository}
 *
 */
@Repository(value="permissaoRepository")
public interface IPermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
	
	public PermissaoEntity findById(Long id);

}
