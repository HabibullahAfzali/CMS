package cms.com.CMS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "work_history")
public class WorkHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personal_info_id")
	private PersonalInfo personalInfo;
	@NotBlank
	private String employer;
	@NotBlank
	private String jobTitle;
	@NotBlank
	private Date startDate;
	@NotBlank
	private Date endDate;
}
