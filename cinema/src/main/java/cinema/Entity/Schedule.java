package cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Price")
    private double price;
    @Column(name = "StartAt")
    private Date startAt;
    @Column(name = "EndAt")
    private Date endAt;
    @Column(name = "Code")
    private String code;
    @Column(name = "MovieId", insertable = false, updatable = false)
    private int movieId;
    @Column(name = "Name")
    private String name;
    @Column(name = "RoomId", insertable = false, updatable = false)
    private int roomId;
    @Column(name = "IsActive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "MovieId")
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    @JsonIgnore
    private Room room;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Ticket> tickets;
}
