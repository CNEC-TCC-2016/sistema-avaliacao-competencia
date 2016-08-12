package br.com.project.checkskills.repositories.autenticacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;

@Repository(value="usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	public UsuarioEntity findById(Long id);
	public UsuarioEntity findByUsernameAndPassword(String username,String password);
	public List<UsuarioEntity> findByEmail(String email);
	

}
