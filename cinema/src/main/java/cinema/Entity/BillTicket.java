package cinema.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "billTickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "BillId", insertable = false, updatable = false)
    private int billId;
    @Column(name = "TicketId", insertable = false, updatable = false)
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "BillId")
    @JsonIgnore
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "TicketId")
    @JsonIgnore
    private Ticket ticket;
}
