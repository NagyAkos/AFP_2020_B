package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserves {
    private int id;
    private String guestName;
    private boolean campingStyle;
    private boolean electricity;
}
