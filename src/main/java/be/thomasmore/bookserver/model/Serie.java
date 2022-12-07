package be.thomasmore.bookserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Serie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;


    public Serie(int id) {
        this.id = id;
    }

}
