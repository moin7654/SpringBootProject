package com.database;

import com.database.dao.BookDao;
import com.database.entity.Book;
import com.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class SpringDatabaseProjectApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookDao bookDao;

	@Test
	void saveUserTest() {
		User user=new User();
		user.setId(500+(new Random().nextInt(1000)));
		user.setName("Moin Farooqui");
		user.setCity("Delhi");
		user.setSalary(5000);
		int rows=userRepository.saveUser(user);
		Assertions.assertEquals(1,rows);
	}

	@Test
	void createUserTableTest(){
		int updated=userRepository.createUserTable();
		System.out.println(updated);
	}

	@Test
	void deleteUserTest(){
		int rowsDeelted= userRepository.deleteUser(983);
		System.out.println("Rows Deleted: "+rowsDeelted);
	}

	@Test
	void updatedUserTest(){
		User user=new User();
		user.setName("Fahad");
		user.setCity("Kanpur");
		user.setSalary(5400);
		user.setId(49);
		int updatedRows= userRepository.updateUser(user);
		System.out.println("Updated Rows: "+updatedRows);
	}

	@Test
	public void saveBook(){
		Book book=new Book();
		book.setTitle("Maths By Moin");
		book.setAuthor("Moin");
		book.setAbout("Concept of Maths");
		book.setLanguage("English");
		book.setAvailable(true);
		//System.out.println(book);
		Book bookResponse= bookDao.saveBook(book);
	}

}
