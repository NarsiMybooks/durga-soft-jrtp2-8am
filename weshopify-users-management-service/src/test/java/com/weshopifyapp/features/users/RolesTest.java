package com.weshopifyapp.features.users;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weshopifyapp.features.users.data.models.RoleToPermissions;
import com.weshopifyapp.features.users.data.models.WeshopifyRoles;
import com.weshopifyapp.features.users.data.repository.PermissionsRepository;
import com.weshopifyapp.features.users.data.repository.WeshopifyRolesRepository;

public class RolesTest extends PermissionsTest {

	@Autowired
	private WeshopifyRolesRepository rolesRepo;
	
	@Autowired
	private PermissionsRepository permissions;
	
	@Test
	@Order(value = 2)
	public void testCreateRole() {
		
		
		WeshopifyRoles role = new WeshopifyRoles();
		role.setName("Admin");
		RoleToPermissions rolesToPerm = RoleToPermissions.builder()
										.permissions(permissions.findById(1).get())
										.roles(role).build();
		role.setRole_to_permissions(Arrays.asList(rolesToPerm));
		rolesRepo.save(role);
		assertNotNull(role.getRole_to_permissions());
		assertNotNull(role.getRoleId());
	}
}
