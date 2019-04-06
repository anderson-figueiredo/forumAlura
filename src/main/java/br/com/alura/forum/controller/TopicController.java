package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;

@RestController
public class TopicController {

	@ResponseBody
	@GetMapping
	public List<Topic> listTopics() {
		Category subCategory = new Category("Scrum", new Category("Negócio"));
		Course course = new Course("Gerenciamento ágil com Scrum", subCategory);
		Topic topic = new Topic("Métricas", "Como definir boas métricas para o time", new User("Bina", "bina@contato.com", "temcerteza"), course);
		
		return Arrays.asList(topic, topic, topic);
	}
}
