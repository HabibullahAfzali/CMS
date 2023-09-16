package cms.com.CMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cms.com.CMS.model.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
}
