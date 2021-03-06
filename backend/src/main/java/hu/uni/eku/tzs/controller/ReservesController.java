package hu.uni.eku.tzs.controller;
import hu.uni.eku.tzs.controller.dto.ReservesDto;
import hu.uni.eku.tzs.controller.dto.ReservesRecordRequestDto;
import hu.uni.eku.tzs.model.Reserves;
import hu.uni.eku.tzs.service.ReservesService;
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
@RequestMapping(value = "/reserves")
@RequiredArgsConstructor
@Api(tags = "Reserves")
@Slf4j

public class ReservesController {

    private final ReservesService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    ReservesRecordRequestDto request
    ){
        log.info("Reserve informations: ({},{},{},{})",request.getId(),request.getGuestId(),request.getPrice(),request.getReserveEnd(),request.getReserveStart());
        try {
            service.record(new Reserves(request.getId(),request.getGuestId(),request.getCampId(),request.isCampingStyle(), request.isElectricity(),request.getPrice(),request.getReserveStart(),request.getReserveEnd()));
        } catch (Exception e) {
            log.info("Reserve is already exists! Message: {},{},{},{}", request.getGuestId(),request.getReserveEnd(),request.getReserveStart(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Reserves")
    public Collection<ReservesDto> query(){
        return service.readAll().stream().map(model ->
                ReservesDto.builder()
                        .id(model.getId())
                        .guestId(model.getGuestId())
                        .campingStyle(model.isCampingStyle())
                        .electricity(model.isElectricity())
                        .price(model.getPrice())
                        .reserveStart(model.getReserveStart())
                        .reserveEnd(model.getReserveEnd()
                        )
                        .build()
        ).collect(Collectors.toList());
    }
    @ApiOperation(value= "Delete reserve")
    @DeleteMapping("/{id}")
    void deleteReserve(@PathVariable int id){
        service.delete(id);
    }
}
