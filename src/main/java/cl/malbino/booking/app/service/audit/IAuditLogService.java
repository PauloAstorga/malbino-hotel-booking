package cl.malbino.booking.app.service.audit;

import cl.malbino.booking.app.model.entity.AuditLog;

import java.time.LocalDate;
import java.util.List;

public interface IAuditLogService {

    public List<AuditLog> findAll();

    public AuditLog findById(long id);

    public AuditLog findByLog(String log);

    public AuditLog findByType(String type);

    public AuditLog findByDate(LocalDate from, LocalDate to);

}
