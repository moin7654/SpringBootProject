package com.database.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Book {

    private int id;
    private String title;
    private String about;
    private String author;
    private String language;
    private Boolean available = true;

}
