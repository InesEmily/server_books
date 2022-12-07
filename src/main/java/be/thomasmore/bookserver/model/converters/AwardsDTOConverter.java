package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Awards;
import be.thomasmore.bookserver.model.dto.AwardsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AwardsDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public AwardsDTO convertToDto(Awards awards) {
        return modelMapper.map(awards, AwardsDTO.class);
    }

}