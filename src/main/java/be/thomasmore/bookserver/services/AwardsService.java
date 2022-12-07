package be.thomasmore.bookserver.services;

import be.thomasmore.bookserver.model.Awards;
import be.thomasmore.bookserver.model.converters.AwardsDTOConverter;
import be.thomasmore.bookserver.model.converters.AwardsDetailedDTOConverter;
import be.thomasmore.bookserver.model.dto.AwardsDTO;
import be.thomasmore.bookserver.model.dto.AwardsDetailedDTO;
import be.thomasmore.bookserver.repositories.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AwardsService {
    @Autowired
    private AwardsRepository awardsRepository;

    @Autowired
    private AwardsDTOConverter awardsDTOConverter;

    @Autowired
    private AwardsDetailedDTOConverter awardsDetailedDTOConverter;

    public List<AwardsDTO> findAll(String titleKeyWord) {
        final List<Awards> awards = titleKeyWord == null ?
                awardsRepository.findAll() :
                awardsRepository.findByTitleContainingIgnoreCase(titleKeyWord);

        return awards.stream()
                .map(a -> awardsDTOConverter.convertToDto(a))
                .collect(Collectors.toList());
    }
    public AwardsDetailedDTO findOne(int id) {
        final Optional<Awards> award = awardsRepository.findById(id);
        if (award.isEmpty())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Award with id %d does not exist.", id));

        return awardsDetailedDTOConverter.convertToDto(award.get());
    }


}