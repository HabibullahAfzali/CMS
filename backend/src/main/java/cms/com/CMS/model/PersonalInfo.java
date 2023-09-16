package cms.com.CMS.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "personal_info")
public class PersonalInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private Gender gender;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nationality_id")
	private Nationality nationality;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marital_status_id")
	private MaritalStatus maritalStatus;
	@Column(unique = true)
	@NotBlank
	private String identityNumber;
	@NotBlank
	private String firstName;
	private String lastName;
	@NotBlank
	private Date dateOfBirth;
	@Column(unique = true)
	@NotBlank
	private String contactNumber;
	@Column(unique = true)
	@Email
	@NotBlank
	private String emailAddress;

}
