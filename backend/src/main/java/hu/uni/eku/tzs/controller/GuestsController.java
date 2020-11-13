package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.GuestsDto;
import hu.uni.eku.tzs.controller.dto.GuestsRecordRequestDto;
import hu.uni.eku.tzs.model.Guests;
import hu.uni.eku.tzs.service.GuestsService;
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
@RequestMapping(value = "/guests")
@RequiredArgsConstructor
@Api(tags = "Guests")
@Slf4j
public class GuestsController {

    private final GuestsService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    GuestsRecordRequestDto request
    ){
        log.info("Guest informations: ({},{},{},{},{})",request.getId(),request.getGuestName(),request.getEmail(),request.getPhone());
        try {
            service.record(new Guests(request.getId(),request.getGuestName(),request.getEmail(),request.getPhone()));
        } catch (Exception e) {
            log.info(" Guest ({},{}) is already exists! Message: {}", request.getId(),request.getGuestName(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Guests")
    public Collection<GuestsDto> query(){
        return service.readAll().stream().map(model ->
                GuestsDto.builder()
                .id(model.getId())
                .guestName(model.getGuestName())
                        .email(model.getEmail())
                        .phone((model.getPhone()))
                .build()
        ).collect(Collectors.toList());
    }

    @ApiOperation(value= "Delete guest")
    @DeleteMapping("/{id}")
    void deleteGuest(@PathVariable int id){
        service.delete(id);
    }

}
