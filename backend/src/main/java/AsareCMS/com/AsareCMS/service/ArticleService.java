package AsareCMS.com.AsareCMS.service;

import AsareCMS.com.AsareCMS.model.Article;
import AsareCMS.com.AsareCMS.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

	private final ArticleRepository articleRepository;
@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

public List<Article> getAllArticles(){

	return articleRepository.findAll();
}
public Optional<Article> getArticalById(Long id){
	return  articleRepository.findById(id);
}

public Article PostArticle(Article article){

	return articleRepository.save(article);
}

}
