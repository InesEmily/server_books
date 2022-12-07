package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Author;
import be.thomasmore.bookserver.model.Book;
import be.thomasmore.bookserver.model.Serie;
import be.thomasmore.bookserver.model.dto.BookDetailedDTO;
import be.thomasmore.bookserver.model.dto.SerieDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Component
public class SerieDetailedDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param serie the entity from the db
     * @return SerieDTO object to send to the client.
     */
    public SerieDetailedDTO convertToDto(Serie serie) {
        return modelMapper.map(serie, SerieDetailedDTO.class);
    }

    public Serie convertToEntity(SerieDetailedDTO serieDto, Serie serie) {
        modelMapper.map(serieDto, serie);
        return serie;
    }
    public Serie convertToEntity(SerieDetailedDTO serieDto) {
        final Serie serie = modelMapper.map(serieDto, Serie.class);
        return serie;
    }

}