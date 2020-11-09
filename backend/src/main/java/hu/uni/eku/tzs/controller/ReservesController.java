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
        log.info("Reserve informations: ({},{},{})",request.getGuestName(),request.isCampingStyle(),request.isElectricity());
        try {
            service.record(new Reserves(request.getGuestName(),request.isCampingStyle(),request.isElectricity()));
        } catch (Exception e) {
            log.info("Reserve is already exists! Message: {},{},{},{}", request.getGuestName(),request.isCampingStyle(),request.isElectricity(), e.getMessage());
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
                        .guestName(model.getGuestName())
                        .campingStyle(model.isCampingStyle())
                        .electricity(model.isElectricity())
                        .build()
        ).collect(Collectors.toList());
    }
}
