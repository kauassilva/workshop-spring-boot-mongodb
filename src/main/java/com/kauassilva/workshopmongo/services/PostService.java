package com.kauassilva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kauassilva.workshopmongo.domain.Post;
import com.kauassilva.workshopmongo.repository.PostRepository;
import com.kauassilva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
}