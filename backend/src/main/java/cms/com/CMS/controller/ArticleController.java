package cms.com.CMS.controller;

import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.Article;
import cms.com.CMS.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/articles")
public class ArticleController {
	private final ArticleService articleService;
@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	@GetMapping

	public List<Article> getAllArticles(){

	return articleService.getAllArticles();
	}
	@GetMapping("/{id}")
	public Article getArticalById(@PathVariable Long id){
	return articleService.getArticalById(id).orElseThrow(()-> new ResourceNotFoundException("Article not found!" + id));
	}
	@PostMapping
	public Article CreateArticle(@RequestBody Article article){
	return  articleService.PostArticle(article);
	}
}
