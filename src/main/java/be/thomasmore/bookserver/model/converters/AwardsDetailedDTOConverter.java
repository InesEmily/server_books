package be.thomasmore.bookserver.model.converters;

import be.thomasmore.bookserver.model.Awards;
import be.thomasmore.bookserver.model.dto.AwardsDetailedDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AwardsDetailedDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public AwardsDetailedDTO convertToDto(Awards awards) {
        return modelMapper.map(awards, AwardsDetailedDTO.class);
    }

}
