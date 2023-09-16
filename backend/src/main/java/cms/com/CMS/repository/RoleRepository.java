package cms.com.CMS.repository;

import cms.com.CMS.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
@NonNull
	 List<RoleEntity> findAll( );
	Optional<RoleEntity> findByName(String name);
}
