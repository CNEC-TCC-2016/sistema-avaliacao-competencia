package br.com.project.checkskills.test.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import br.com.project.checkskills.entities.dadosbasicos.CargoEntity;
import br.com.project.checkskills.entities.dadosbasicos.NivelEntity;
import br.com.project.checkskills.repositories.dadosbasicos.ICargoRepository;
import br.com.project.checkskills.repositories.dadosbasicos.INivelRepository;
import br.com.project.checkskills.test.utils.AbstractDatabaseTest;


public class CargoRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger
			.getLogger(CargoRepositoryTest.class);

	@Inject
	private ICargoRepository cargoRepository;
	@Inject
	private INivelRepository nivelRepository;

	@Ignore
	@Test
	public void delete() {
		CargoEntity cargoEntity = new CargoEntity();
		cargoEntity.setId(2L);
		this.cargoRepository.delete(cargoEntity);
		LOGGER.info(cargoEntity);

	}
   // @Ignore
	//@Test
	//public void testPesquisar() {
		//List<CargoEntity> cargos = cargoRepository
			//	.findByNomeCargo("Administrador");

		//LOGGER.info(cargos);

	//}

	@Ignore
	@Test
	public void testFindAll() {
		List<CargoEntity> cargos = this.cargoRepository.findAll();

		LOGGER.info(cargos);
	}

    @Ignore
	@Test
	public void testEditar() {

		NivelEntity nivelEntity = new NivelEntity();
		nivelEntity.setId(1L);
		nivelEntity.setNivel("Sênior");

		CargoEntity cargoEntity = new CargoEntity();
		cargoEntity.setId(4L);
		cargoEntity.setNomeCargo("Analista I");
		cargoEntity.setDescricao("Departamento ANA I ");

		cargoEntity.setNivelEntity(nivelEntity);

		try {
			this.cargoRepository.save(cargoEntity);

		} catch (Exception e) {
			e.printStackTrace();

		}

		LOGGER.info(cargoEntity);

	}

	//@Ignore
	@Test
	public void testIncluir() {

		NivelEntity nivelEntity = new NivelEntity();

		nivelEntity.setId(1L);
		nivelEntity.setNivel("pleno");

		CargoEntity cargoEntity = new CargoEntity();
		cargoEntity.setNomeCargo("Analista");
		cargoEntity.setDescricao("Departamento ANA ");

		cargoEntity.setNivelEntity(nivelEntity);

		try {
			this.cargoRepository.save(cargoEntity);

		} catch (Exception e) {
			e.printStackTrace();

		}

		LOGGER.info(cargoEntity);

	}

	public INivelRepository getNivelRepository() {
		return nivelRepository;
	}

	public void setNivelRepository(INivelRepository nivelRepository) {
		this.nivelRepository = nivelRepository;
	}

}
