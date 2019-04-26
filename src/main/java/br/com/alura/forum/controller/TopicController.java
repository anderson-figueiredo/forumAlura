package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;

@RestController
public class TopicController {

	@ResponseBody
	@GetMapping(value="/api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutputDto> listTopics() {
		Category subCategory = new Category("Scrum", new Category("Negócio"));
		Course course = new Course("Gerenciamento ágil com Scrum", subCategory);
		Topic topic = new Topic("Métricas", "Como definir boas métricas para o time", new User("Bina", "bina@contato.com", "temcerteza"), course);
		
		List<Topic> topics = Arrays.asList(topic, topic, topic);
		return TopicBriefOutputDto.listFromTopics(topics);
	}
}
