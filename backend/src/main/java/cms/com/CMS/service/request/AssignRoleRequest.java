package cms.com.CMS.service.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AssignRoleRequest {
	private Long userId;
	private Long roleId;
}

