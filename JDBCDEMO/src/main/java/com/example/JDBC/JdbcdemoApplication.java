package com.example.JDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.JDBC.model.Student;
import com.example.JDBC.repo.Studentrepo;




@SpringBootApplication
public class JdbcdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(JdbcdemoApplication.class, args);
		Student st =context.getBean(Student.class);
		st.setId(1);
		st.setName("jagan");
		st.setDep("ECE");
		System.out.println(st);
		
	     Studentrepo repo =context.getBean(Studentrepo.class);
	     repo.save(st);
	     System.out.println(repo.findall());
	     
	     
	}

}
