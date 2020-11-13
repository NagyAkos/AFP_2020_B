package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.InvoicesDto;
import hu.uni.eku.tzs.controller.dto.InvoicesRecordRequestDto;
import hu.uni.eku.tzs.model.Invoices;
import hu.uni.eku.tzs.service.InvoicesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/invoices")
@RequiredArgsConstructor
@Api(tags = "Invoices")
@Slf4j
public class InvoicesController {

    private final InvoicesService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    InvoicesRecordRequestDto request
    ){
        log.info("Invoices informations: ({},{})",request.getId(),request.getQuestId(),request.getReserveId(),request.getPaymentMethod());
        try {
            service.record(new Invoices(request.getId(),request.getQuestId(),request.getPaymentMethod(),request.getReserveId()));
        } catch (Exception e) {
            log.info(" Invoice ({},{}) is already exists! Message: {}", request.getId(),request.getQuestId(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Invoices")
    public Collection<InvoicesDto> query(){
        return service.readAll().stream().map(model ->
                InvoicesDto.builder()
                        .id(model.getId())
                        .questId(model.getQuestId())
                        .paymentMethod(model.getPaymentMethod())
                        .reserveId(model.getReserveId())
                        .build()
        ).collect(Collectors.toList());
    }

    @ApiOperation(value= "Delete invoice")
    @DeleteMapping("/{id}")
    void deleteInvoice(@PathVariable int id){
        service.delete(id);
    }



}
