package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.AwardsDTO;
import be.thomasmore.bookserver.model.dto.AwardsDetailedDTO;
import be.thomasmore.bookserver.model.dto.SerieDTO;
import be.thomasmore.bookserver.model.dto.SerieDetailedDTO;
import be.thomasmore.bookserver.services.AwardsService;
import be.thomasmore.bookserver.services.SerieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/awards")
@Slf4j
public class AwardsController {
    @Autowired
    private AwardsService awardsService;

    @Operation(summary = "list of awards in the database.",
            description = "Returns a list of all awards: " )
    @GetMapping("")
    public Iterable<AwardsDTO> findAll() {
        return awardsService.findAll();
    }

    @Operation(summary = "get 1 serie from the database.",
            description = "Award with id is fetched from database - returns detailed ino. ")
    @GetMapping("{id}")
    public AwardsDetailedDTO findOne(@PathVariable int id) {
        log.info(String.format("##### find One award %d", id));
        return awardsService.findOne(id);
    }


}
