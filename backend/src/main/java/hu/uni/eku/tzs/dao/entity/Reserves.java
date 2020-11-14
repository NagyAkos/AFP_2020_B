package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Reserves {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int guestId;
    @Column
    private int campId;
    @Column
    private boolean campingStyle;
    @Column
    private boolean electricity;
    @Column
    private int price;
    @Column
    private LocalDate reserveStart;
    @Column
    private LocalDate reserveEnd;
}
