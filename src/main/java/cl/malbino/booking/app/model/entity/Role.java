package cl.malbino.booking.app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
        @NamedQuery(name = "Role.findByCode", query = "SELECT r FROM Role r WHERE UPPER(r.code) LIKE UPPER(:code)"),
        @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE UPPER(r.name) LIKE UPPER(:name)")
})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, unique = true, nullable = false)
    private String name;

    @Column(name = "code", length = 3, unique = true, nullable = false)
    private String code;

}
