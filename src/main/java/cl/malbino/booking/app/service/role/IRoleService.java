package cl.malbino.booking.app.service.role;

import cl.malbino.booking.app.model.entity.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll();

    public Role findById(long id);

    public Role findByName(String name);

    public Role findByCode(String code);

}
