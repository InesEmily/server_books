package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Author;
import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.dto.AuthorDetailedDTO;
import be.thomasmore.bookserver.model.dto.BookDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AuthorDetailedDTOConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthorDTOConverter authorDTOConverter;


    public AuthorDetailedDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDetailedDTO.class);
    }
}
