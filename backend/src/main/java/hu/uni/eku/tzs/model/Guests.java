package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guests {
    private int id;
    private String guestName;
    private String paymentMethod;
    private int campingId;
    private LocalDate reserveDate;
}
