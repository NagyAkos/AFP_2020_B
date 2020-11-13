package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.CampsDto;
import hu.uni.eku.tzs.controller.dto.CampsRecordRequestDto;
import hu.uni.eku.tzs.model.Camps;
import hu.uni.eku.tzs.service.CampsService;
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
@RequestMapping(value = "/camps")
@RequiredArgsConstructor
@Api(tags = "Camps")
@Slf4j

public class CampsController {

    private final CampsService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    CampsRecordRequestDto request
    ){
        log.info("Camp information: ({})",request.getId());
        try {
            service.record(new Camps(request.getId()));
        } catch (Exception e) {
            log.info(" Camp ({}) is already exists! Message: {}", request.getId(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Camps")
    public Collection<CampsDto> query(){
        return service.readAll().stream().map(model ->
                CampsDto.builder()
                        .id(model.getId())
                        .build()
        ).collect(Collectors.toList());
    }

    @ApiOperation(value= "Delete camp")
    @DeleteMapping("/{id}")
    void deleteCamp(@PathVariable int id){
        service.delete(id);
    }

}
