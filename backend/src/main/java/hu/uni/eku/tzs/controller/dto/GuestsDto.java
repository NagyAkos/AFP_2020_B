package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GuestsDto
{
    private int id;
    private String guestName;
    private String paymentMethod;
    private int campingId;
    private LocalDate reserveDate;
}
