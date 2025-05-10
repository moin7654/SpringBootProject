package com.database.dao;

import com.database.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {


    private JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // save the book
    public Book saveBook(Book book){
        String sql="insert into book(id,title,about,author,language,available) values(?,?,?,?,?,?)";
        int rowsUpdated= jdbcTemplate.update(
                 sql,
                 book.getId(),
                 book.getTitle(),
                 book.getAbout(),
                 book.getAuthor(),
                 book.getLanguage(),
                 book.getAvailable()
                 );
        System.out.println("Rows Updated: "+rowsUpdated);
        return book;
    }

    // update the book
    public int updateBook(Book book){
      String sql="update book set title=?, about=?, language=? where id=?";
      int rowsUpdated= jdbcTemplate.update(
              sql,
              book.getTitle(),
              book.getAbout(),
              book.getLanguage(),
              book.getId()
              );
        System.out.println("Rows Updated: "+rowsUpdated);

      return rowsUpdated;

    }

    // delete the book
    public int deleteBook(int id){

        String sql="delete from book where id=?";
        int rowsUpdated=jdbcTemplate.update(
                   sql,
                   id
           );

        System.out.println("Rows updated: "+rowsUpdated);
        return rowsUpdated;
    }

    // get the single book
    public Book getSingleBookById(int id){
        String sql="select * from book where id=?";
        Book book= jdbcTemplate.queryForObject(sql,
                new BookRowMapper(),
                id);

        return book;

    }

    // get all book
    public List<Book> getAllBook(){
        String sql="select * from book";
        List<Book> bookList= jdbcTemplate.query(sql,
                new BookRowMapper());

        return bookList;

    }

    public List<Book> searchBook(String titleKeyword){

        String sql="select * from book where title like ?";
        List<Book> bookList= jdbcTemplate.query(
                sql,
                new BookRowMapper(),
                "%"+titleKeyword+"%"
                );

        return bookList;

    }


}
