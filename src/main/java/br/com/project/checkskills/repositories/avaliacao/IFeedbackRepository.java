package br.com.project.checkskills.repositories.avaliacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.checkskills.entities.dadosbasicos.CompetenciaEntity;
import br.com.project.checkskills.entities.dadosbasicos.FeedbackEntity;

@Repository(value="feedbackRepository")
public interface IFeedbackRepository extends JpaRepository<FeedbackEntity, Long>{
	
}
