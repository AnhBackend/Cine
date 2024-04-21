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
@Table(name = "rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Description")
    private String description;
    @Column(name = "Code")
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rate")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Movie> movies;
}
