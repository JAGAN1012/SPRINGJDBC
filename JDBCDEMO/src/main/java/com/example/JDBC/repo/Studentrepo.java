package com.example.JDBC.repo;

import java.sql.ResultSet;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.JDBC.model.Student;

@Repository
public class Studentrepo {

    @Autowired
    private JdbcTemplate template;

    // Getter and Setter for JdbcTemplate (not necessary if using @Autowired)
    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Save a student to the database
    public void save(Student s1) {
//        String sql = "INSERT INTO students (id, name, dep) VALUES (?, ?, ?)";
//       int rows= template.update(sql, s1.getId(), s1.getName(), s1.getDep());
//       System.out.println("rowsaffected: "+rows);
      // String sql = "update students set name=?,dep=? where id=?";
      // int rows= template.update(sql,"jagan","cs",4);
       //System.out.println("rowsaffected: "+rows);
    	 String sql = "DELETE FROM STUDENTS WHERE ID=?";
    	 int rows= template.update(sql,4);
    	
    }

    // Find all students from the database
    public List<Student> findall() {
        String sql = "SELECT * FROM students";
        
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
               Student s =new Student();
               s.setId(rs.getInt(1));
			   s.setName(rs.getString(2));
               s.setDep(rs.getString(3));
               return s;
            }
        };
       
        
        // Execute the query and map each row to a Student object
         List<Student> l=template.query(sql, mapper);
         return l;
    }
}
