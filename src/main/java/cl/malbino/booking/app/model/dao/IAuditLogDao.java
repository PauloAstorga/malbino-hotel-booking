package cl.malbino.booking.app.model.dao;

import cl.malbino.booking.app.model.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IAuditLogDao extends JpaRepository<AuditLog, Long> {

    AuditLog findById(long id);

    AuditLog findByLog(String log);

    AuditLog findByType(String type);

    AuditLog findByDate(LocalDate from, LocalDate to);
}
