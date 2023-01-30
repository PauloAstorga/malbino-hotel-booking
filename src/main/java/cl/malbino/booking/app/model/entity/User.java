package cl.malbino.booking.app.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_user")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE UPPER(u.username) = UPPER(:username)"),
        @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE UPPER(u.mail) = UPPER(:mail)"),
        @NamedQuery(name = "User.findBetweenCreatedAt", query = "SELECT u FROM User u WHERE u.createdAt BETWEEN :from AND :to"),
        @NamedQuery(name = "User.findBetweenModifiedAt", query = "SELECT u FROM User u WHERE u.modifiedAt BETWEEN :from AND :to"),
        @NamedQuery(name = "User.findByRole", query = "SELECT u From User u WHERE u.role.id = :id")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 30, unique = true, nullable = false)
    private String username;

    @Column(name = "mail", length = 100, unique = true, nullable = false)
    private String mail;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "modified_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date modifiedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private Role role;

}
