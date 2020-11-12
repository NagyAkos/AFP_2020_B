package hu.uni.eku.tzs.controller;

import hu.uni.eku.tzs.controller.dto.DeleteDto;
import hu.uni.eku.tzs.controller.dto.DeleteRecordRequestDto;
import hu.uni.eku.tzs.model.Delete;
import hu.uni.eku.tzs.service.DeleteService;
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
@RequestMapping(value = "/delete")
@RequiredArgsConstructor
@Api(tags = "Delete")
@Slf4j
public class DeleteController {

    private final DeleteService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    DeleteRecordRequestDto request
    ){
        log.info("Delete id: ({})",request.getId());
        try {
            service.record(new Delete(request.getId()));
        } catch (Exception e) {
            log.info("Id ({}) is already deleted! Message: {}", request.getId(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Delete")
    public Collection<DeleteDto> query(){
        return service.readAll().stream().map(model ->
                DeleteDto.builder()
                        .id(model.getId())
                        .build()
        ).collect(Collectors.toList());
    }


}
