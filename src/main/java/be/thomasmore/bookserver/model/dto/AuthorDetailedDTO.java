package be.thomasmore.bookserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthorDetailedDTO {
    private int id;
    private String name;

    //more data will be inserted here later...

    private Collection<BookDTO> books;
}
