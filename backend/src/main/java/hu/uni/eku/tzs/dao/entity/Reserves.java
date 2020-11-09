package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Reserves {
    @Id
    private String guestName;
    @Column
    private boolean campingStyle;
    @Column
    private boolean electricity;
}
