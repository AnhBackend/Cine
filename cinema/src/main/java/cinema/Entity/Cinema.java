package cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "cinemas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Address")
    private String address;
    @Column(name = "Description")
    private String description;
    @Column(name = "Code")
    private String code;
    @Column(name = "NameOfCinema")
    private String nameOfCinema;
    @Column(name = "IsActive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Room> rooms;
}
