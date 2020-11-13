package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoicesDto
{   private int id;
    private int questId;
    private String paymentMethod;
    private int reserveId;
}