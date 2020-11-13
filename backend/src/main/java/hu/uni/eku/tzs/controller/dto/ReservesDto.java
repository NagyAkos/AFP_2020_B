package hu.uni.eku.tzs.controller.dto;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class ReservesDto {
    private int id;
    private int guestId;
    private boolean campingStyle;
    private boolean electricity;
    private int price;
    private LocalDate reserveStart;
    private LocalDate reserveEnd;

}
