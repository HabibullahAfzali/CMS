package AsareCMS.com.AsareCMS.model;
import  jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import  java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(LocalDateTime last_updated) {
		this.last_updated = last_updated;
	}

	private String category_name;
	private String description;

	private LocalDateTime created_at;
	private LocalDateTime last_updated;

}
