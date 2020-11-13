package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserves {
    private int id;
    private int guestId;
    private boolean campingStyle;
    private boolean electricity;
    private int price;
    private LocalDate reserveStart;
    private LocalDate reserveEnd;
}
