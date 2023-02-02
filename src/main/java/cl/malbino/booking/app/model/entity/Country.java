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
@Table(name = "country")
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
        @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id"),
        @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE UPPER(c.name) LIKE UPPER(:name)")
})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 60, unique = true)
    private String name;

}
