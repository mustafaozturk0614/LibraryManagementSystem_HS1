package com.bilgeadam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_author")
@NamedQueries({
        @NamedQuery(
            name = "findAuthorIdByFirstNameAndLastName",
            query = "select a.id from Author a where a.firstName=:firstName and a.lastName=:lastName"
        )

})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;


}
