package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.topic.domain.Topic;

public interface TopicRepository extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic> {

	@Query("select t from Topic t")
	List<Topic> list();
	
	Page<Topic> findAll(Specification<Topic> topicSearchSpecification, Pageable pageRequest);
}
