package com.database.dao;


import com.database.entity.Book;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
public class BookRowMapper implements RowMapper<Book> {

    @Autowired
    private Book book;

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        book.setId(rs.getInt("id"));
        book.setAbout(rs.getString("about"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setLanguage(rs.getString("language"));
        book.setAvailable(rs.getBoolean("available"));

        return book;
    }
}
