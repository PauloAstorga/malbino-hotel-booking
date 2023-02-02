package cl.malbino.booking.app.service.audit;

import cl.malbino.booking.app.model.dao.IAuditLogDao;
import cl.malbino.booking.app.model.dao.IRoleDao;
import cl.malbino.booking.app.model.entity.AuditLog;
import cl.malbino.booking.app.model.entity.Role;
import cl.malbino.booking.app.service.role.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AuditLogServiceImpl implements IAuditLogService{

    private Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Autowired
    private IAuditLogDao auditLogDao;

    @Override
    public List<AuditLog> findAll() {
        return auditLogDao.findAll();
    }

    @Override
    public AuditLog findById(long id) {
        return null;
    }

    @Override
    public AuditLog findByLog(String log) {
        return null;
    }

    @Override
    public AuditLog findByType(String type) {
        return null;
    }

    @Override
    public AuditLog findByDate(LocalDate from, LocalDate to) {
        return null;
    }

}
