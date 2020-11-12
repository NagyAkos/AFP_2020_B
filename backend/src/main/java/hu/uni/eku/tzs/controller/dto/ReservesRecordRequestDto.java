package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ReservesRecordRequestDto {
    private int id;
    private String guestName;
    private boolean campingStyle;
    private boolean electricity;
}
