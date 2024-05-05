package com.bilgeadam.entity;

import com.bilgeadam.enums.EBookType;
import com.bilgeadam.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private EBookType bookType;
    private int pageCount;
    private Long authorId;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EStatus status=EStatus.AVAILABLE;

}
