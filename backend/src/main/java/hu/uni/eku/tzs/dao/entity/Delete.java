package hu.uni.eku.tzs.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Delete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
