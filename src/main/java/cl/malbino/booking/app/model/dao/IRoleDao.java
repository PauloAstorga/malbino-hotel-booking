package cl.malbino.booking.app.model.dao;

import cl.malbino.booking.app.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Long> {

    Role findById(long id);

    Role findByName(String name);

    Role findByCode(String code);

}
