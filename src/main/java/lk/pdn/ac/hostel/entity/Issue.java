package lk.pdn.ac.hostel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "issue_table")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issueId;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

}
