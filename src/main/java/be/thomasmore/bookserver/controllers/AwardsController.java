package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.*;
import be.thomasmore.bookserver.services.AwardsService;
import be.thomasmore.bookserver.services.SerieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/awards")
@Slf4j
public class AwardsController {
    @Autowired
    private AwardsService awardsService;


    @Operation(summary = "get 1 serie from the database.",
            description = "Award with id is fetched from database - returns detailed ino. ")
    @GetMapping("{id}")
    public AwardsDetailedDTO findOne(@PathVariable int id) {
        log.info(String.format("##### find One award %d", id));
        return awardsService.findOne(id);
    }
    @Operation(summary = "list of awards in the database.",
            description = "If Request Parameter <b>titleKeyWord</b> is given: " +
                    "only books where the title contains this titleKeyWord (ignore-case). </br>" +
                    "Otherwise all books are returned. </br>" +
                    "</br>" +
                    "The authors Collection contains only id and name. </br>" +
                    "Use GET api/awarsq/{id}/awards  to fetch more info about the authors. ")
    @GetMapping("")
    public Iterable<AwardsDTO> findAll(@RequestParam(required = false) String titleKeyWord) {
        log.info("##### findAll books - titleKeyWord=" + titleKeyWord);
        return awardsService.findAll(titleKeyWord);
    }


}
