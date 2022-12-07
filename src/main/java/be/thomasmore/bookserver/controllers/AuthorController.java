package be.thomasmore.bookserver.controllers;

import be.thomasmore.bookserver.model.dto.AuthorDTO;
import be.thomasmore.bookserver.model.dto.BookDTO;
import be.thomasmore.bookserver.services.AuthorService;
import be.thomasmore.bookserver.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
@Slf4j
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @Operation(summary = "list of authors in the database.",
            description = "If Request Parameter <b>titleKeyWord</b> is given: " +
                    "only books where the title contains this titleKeyWord (ignore-case). </br>" +
                    "Otherwise all books are returned. </br>" +
                    "</br>" +
                    "The authors Collection contains only id and name. </br>" +
                    "Use GET api/authors/ to fetch more info about the authors. ")

    @GetMapping("")
    public Iterable<AuthorDTO> findAll() {
        return authorService.findAll();
    }
}
