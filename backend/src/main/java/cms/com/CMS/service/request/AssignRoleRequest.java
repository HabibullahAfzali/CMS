package cms.com.CMS.service.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class AssignRoleRequest {
	private Long userId;
	private Long roleId;
}

