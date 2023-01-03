package cl.malbino.booking.app.service.role;

import cl.malbino.booking.app.model.dao.IRoleDao;
import cl.malbino.booking.app.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public Role findByCode(String code) {
        return roleDao.findByCode(code);
    }

}
