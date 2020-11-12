package hu.uni.eku.tzs.controller.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservesDto {
    private int id;
    private int guestId;
    private boolean campingStyle;
    private boolean electricity;
}
