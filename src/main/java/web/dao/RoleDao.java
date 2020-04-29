package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

public interface RoleDao {

    Role getRole(String name);
}
