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
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Number")
    private int number;
    @Column(name = "SeatStatusId", insertable = false, updatable = false)
    private int seatStatusId;
    @Column(name = "Line")
    private String line;
    @Column(name = "RoomId", insertable = false, updatable = false)
    private int roomId;
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "SeatTypeId", insertable = false, updatable = false)
    private int seatTypeId;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    @JsonIgnore
    private Room room;

    @ManyToOne
    @JoinColumn(name = "SeatStatusId")
    @JsonIgnore
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "SeatTypeId")
    @JsonIgnore
    private SeatType seatType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Ticket> tickets;
}
