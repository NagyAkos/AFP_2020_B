package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ReservesRecordRequestDto {
    private int id;
    private int guestId;
    private boolean campingStyle;
    private boolean electricity;
    private int price;
    private LocalDate reserveStart;
    private LocalDate reserveEnd;
}
