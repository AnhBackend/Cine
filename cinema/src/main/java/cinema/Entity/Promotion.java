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
@Table(name = "promotions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Percent")
    private int percent;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Type")
    private String type;
    @Column(name = "StartTime")
    private Date startTime;
    @Column(name = "EndTime")
    private Date endTime;
    @Column(name = "Description")
    private String description;
    @Column(name = "Name")
    private String name;
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "RankCustomerId", insertable = false, updatable = false)
    private int rankCustomerId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "rankCustomerId")
    @JsonIgnore
    private RankCustomer rankCustomer;
}
