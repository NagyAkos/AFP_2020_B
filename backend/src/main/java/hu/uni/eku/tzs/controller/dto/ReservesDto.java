package hu.uni.eku.tzs.controller.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservesDto {
    private String guestName;
    private boolean campingStyle;
    private boolean electricity;
}
