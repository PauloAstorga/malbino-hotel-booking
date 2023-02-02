package cl.malbino.booking.app.service.role;

import cl.malbino.booking.app.controller.role.RoleRestController;
import cl.malbino.booking.app.exceptions.ValidationException;
import cl.malbino.booking.app.model.dao.IRoleDao;
import cl.malbino.booking.app.model.entity.AuditLog;
import cl.malbino.booking.app.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RoleServiceImpl implements IRoleService {

    private Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Autowired
    private IRoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        List<Role> roleList = null;

        roleList = roleDao.findAll();

        return roleList;
    }

    @Override
    public Role findById(long id) {
        Optional<Role> role = null;

        try {
            role = Optional.ofNullable(roleDao.findById(id));

            if ( !role.isPresent() ) throw new ValidationException("Role [ID:"+id+"] not found.");

        } catch (ValidationException e) {
            logger.log(Level.SEVERE, e.getMessage());

            String log = e.getMessage().toLowerCase();
            String type = "error";

            AuditLog auditLog = AuditLog.builder().log(log).type(type).build();
        }

        return role.get();
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
