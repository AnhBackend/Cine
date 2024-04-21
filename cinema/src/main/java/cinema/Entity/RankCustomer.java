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
@Table(name = "rankCustomers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Point")
    private int point;
    @Column(name = "Description")
    private String description;
    @Column(name = "Name")
    private String name;
    @Column(name = "IsActive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Promotion> promotions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rankCustomer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<User> users;
}
