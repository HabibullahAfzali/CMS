package cms.com.CMS.service;

import cms.com.CMS.service.request.AssignRoleRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	void assignRolesToUser(AssignRoleRequest assignRoleRequest);
}
