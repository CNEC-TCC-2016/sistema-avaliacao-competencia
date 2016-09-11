package br.com.project.checkskills.test.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;
import br.com.project.checkskills.entities.dadosbasicos.FuncionarioEntity;
import br.com.project.checkskills.repositories.autenticacao.IUsuarioRepository;
import br.com.project.checkskills.repositories.dadosbasicos.IFuncionarioRepository;


public class UserRepositoryTest  {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Inject
	private IUsuarioRepository userRepository;
	
	@Inject
	private IFuncionarioRepository funcionarioRepository;
	
	@Ignore
	@Test
	public void testDelete() {
		this.funcionarioRepository.delete(1L);
	}
	
	@Test
	public void testDepartamento()
	{
		FuncionarioEntity funcionario = this.funcionarioRepository.findOne(2L);
		List<FuncionarioEntity> lider =  	
		this.funcionarioRepository.procuraEmDepartamentos(
				funcionario.getCargo().getDepartamento().getId());
		
		lider = new ArrayList<>( new HashSet<FuncionarioEntity>(lider));
		
		LOGGER.info(lider);
	}
	
	@Ignore
	@Test
	public void testFindAll() {
		
		List<UsuarioEntity> users = this.userRepository.findAll();

		LOGGER.info(users);
	}

	@Ignore
	@Test
	public void user() {
		
		UsuarioEntity usuarioEntity = this.userRepository.findById(1L);
		 LOGGER.info(usuarioEntity);
	}
	
	@Ignore
	@Test
	public void saveUser(){
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setId(3L);
		usuarioEntity.setUsername("luan");
		usuarioEntity.setPassword("1312313");
		usuarioEntity.setEmail("pedro@lucas.com");
		
		
		FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
		funcionarioEntity.setId(3L);
		funcionarioEntity.setNome("luan atualizado");
		funcionarioEntity.setUsuarioEntity(usuarioEntity);
		
//		usuarioEntity.setFuncionarioEntity(funcionarioEntity);
		
		try {
		this.funcionarioRepository.save(funcionarioEntity);	
		
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		
		LOGGER.info(funcionarioEntity);
	}

	@Test
	public void userPermission(){
	
//		UsuarioEntity usuarioEntity = new UsuarioEntity();
//		usuarioEntity.setId(254L);
//		usuarioEntity.setUsername("Luan lucsa");
//		usuarioEntity.setPassword("sasdfasd");
//		usuarioEntity.setEmail("asdfsad@adsfdas");
//		
//		PermissaoEntity permissaoEntity1 = new PermissaoEntity();
//		permissaoEntity1.setId(1L);
//		permissaoEntity1.setRole("ROLE_USER");
//		
//		PermissaoEntity permissaoEntity2 = new PermissaoEntity();
//		permissaoEntity2.setId(2L);
//		permissaoEntity2.setRole("ROLE_ADMIN");
//		
//		List<PermissaoEntity> list = new ArrayList<>();
//		list.add(permissaoEntity1);
//	
//		
//		
//		
//		usuarioEntity.setPermissions(list);
//		
//		
//		this.userRepository.save(usuarioEntity);
//		
//		LOGGER.info(usuarioEntity);
	}
	
	public IFuncionarioRepository getFuncionarioRepository() {
		return funcionarioRepository;
	}

	public void setFuncionarioRepository(IFuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
}
