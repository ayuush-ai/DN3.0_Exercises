package com.example.bookstoreapi.dto;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private double price;
    
    
    
    @Mapper
    public interface BookMapper {
        BookDTO toDTO(Book book);
        Book toEntity(BookDTO bookDTO);
    }

}

