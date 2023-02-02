package cl.malbino.booking.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit_log")
@NamedQueries({
        @NamedQuery(name = "AuditLog.findAll", query = "SELECT a FROM AuditLog a"),
        @NamedQuery(name = "AuditLog.findById", query = "SELECT a FROM AuditLog a WHERE a.id = :id"),
        @NamedQuery(name = "AuditLog.findByType", query = "SELECT a FROM AuditLog a WHERE UPPER(a.type) LIKE UPPER(:type)"),
        @NamedQuery(name = "AuditLog.findByLog", query = "SELECT a FROM AuditLog a WHERE UPPER(a.log) LIKE UPPER(:log)"),
        @NamedQuery(name = "AuditLog.findByDate", query = "SELECT a FROM AuditLog a WHERE a.registeredAt BETWEEN (:from) AND (:to)")
})
public class AuditLog {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type", length = 20, nullable = false)
    private String type;

    @Column(name = "log", length = 2000, nullable = false)
    private String log;

    @Column(name = "registered_at", nullable = false, updatable = false)
    private LocalDate registeredAt;

    @PrePersist
    public void prePersist() {
        this.registeredAt = LocalDate.now();
    }

}
