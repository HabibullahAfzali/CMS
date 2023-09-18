package cms.com.CMS.TestController;

import cms.com.CMS.model.Article;
import cms.com.CMS.model.Category;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ArticleControllerTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testCreateArticle() throws Exception {
		// Create an Article object and convert it to JSON
		Article article = new Article();
		article.setTitle("Test Article");
		article.setContent("Test content");
		String articleJson = asJsonString(article);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/createArticle")
						.contentType(MediaType.APPLICATION_JSON)
						.content(articleJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();


		String responseJson = result.getResponse().getContentAsString();
		Article createdArticle = objectMapper.readValue(responseJson, Article.class);
		assertThat(createdArticle.getTitle()).isEqualTo("Test Article");


	}

	@Test
	public void testGetAllArticles() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/getArticles"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		String responseJson = result.getResponse().getContentAsString();
		List<Article> articles = objectMapper.readValue(responseJson, new TypeReference<List<Article>>() {});
		assertThat(articles).isNotEmpty();


	}

	@Test
	public void testGetArticleById() throws Exception {

		Long articleId = 1L;

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/findArticleById/{id}", articleId))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String responseJson = result.getResponse().getContentAsString();
		Article article = objectMapper.readValue(responseJson, Article.class);
		assertThat(article.getId()).isEqualTo(articleId);

	}

//	@Test
//	public void testGetAllCategories() throws Exception {
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/getArticleCategories"))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andReturn();
//
//		// Parse the response JSON to check if it's a list of categories
//		String responseJson = result.getResponse().getContentAsString();
//		List<Category> categories = objectMapper.readValue(responseJson, new TypeReference<List<Category>>() {});
//		assertThat(categories).isNotEmpty();
//
//
//	}

	private static String asJsonString(Object obj) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
}
