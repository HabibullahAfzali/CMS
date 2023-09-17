package cms.com.CMS.controller;

import cms.com.CMS.exception.ResourceNotFoundException;
import cms.com.CMS.model.Article;
import cms.com.CMS.model.Category;
import cms.com.CMS.service.ArticleService;
import cms.com.CMS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private  CategoryService categoryService;
	@PostMapping("/createArticle")
	public Article CreateArticle(@RequestBody Article article){
		return  articleService.PostArticle(article);
	}
	@GetMapping("/getArticles")
	public List<Article> getAllArticles(){

	return articleService.getAllArticles();
	}

	@GetMapping("/findArticleById/{id}")
	public Article getArticleById(@PathVariable Long id){
	return articleService.getArticalById(id).orElseThrow(()-> new ResourceNotFoundException("Article not found!" + id));
	}

	@GetMapping("/getArticleCategories")
	public List<Category> getAllCategories(){

		return categoryService.getAllCategories();
	}
}
