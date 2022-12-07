package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.BookDetailedDTO;
import be.thomasmore.bookserver.model.dto.SerieDTO;
import be.thomasmore.bookserver.model.dto.SerieDetailedDTO;
import be.thomasmore.bookserver.services.SerieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/series")
@Slf4j
public class SerieController {

    @Autowired
    private SerieService serieService;

    @Operation(summary = "list of series in the database.",
            description = "Returns a list of all series: " )
    @GetMapping("")
    public Iterable<SerieDTO> findAll() {
        return serieService.findAll();
    }

    @Operation(summary = "get 1 serie from the database.",
            description = "Serie with id is fetched from database - returns detailed ino. ")
    @GetMapping("{id}")
    public SerieDetailedDTO findOne(@PathVariable int id) {
        log.info(String.format("##### find One serie %d", id));
        return serieService.findOne(id);
    }
    @Operation(summary = "create a new Serie in the database.",
            description = "The authors are <b>not</b> updated in the new book.</br>" +
                    "Use PUT api/series/{id}/series to update those. </br>" +
                    "</br>" +
                    "Returns new serie (containing id from database). ")
    @PostMapping("")
    public SerieDetailedDTO create(@Valid @RequestBody SerieDetailedDTO serieDto) {
        log.info("##### create book");
        return serieService.create(serieDto);
    }



}