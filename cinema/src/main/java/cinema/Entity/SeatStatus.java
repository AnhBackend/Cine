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
@Table(name = "seatStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Code")
    private String code;
    @Column(name = "NameStatus")
    private String nameStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seatStatus")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Seat> seats;

}
