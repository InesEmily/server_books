package be.thomasmore.bookserver.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"books"})
@ToString(exclude = {"books"})
@Entity
public class Awards {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String title;
    private String info;
    private String country;

    @ManyToMany(mappedBy = "awards", fetch = FetchType.LAZY)
    private Set<Book> books;

    public Awards(int id) {
        this.id = id;
    }

}
