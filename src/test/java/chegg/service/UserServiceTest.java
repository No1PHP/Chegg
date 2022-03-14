package chegg.service;

import static org.junit.jupiter.api.Assertions.*;

import chegg.model.pojo.Student;
import java.sql.SQLException;
import java.util.List;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void getStudentsBySchool() {

  }


  @Test
  @Ignore
  void getStudents() throws SQLException {
    List<Student> students = userService.getStudents();
    Assertions.assertEquals(students.size(), 2);
  }

  @Test
  void getProfs() {
  }

  @Test
  void getProfessorsByCourse() {
  }

  @Test
  void getCoursesByProfessor() {
  }

  @Test
  void getStudentByEmail() {
  }

  @Test
  void getProfessorByEmail() {
  }

  @Test
  void addStudent() {
  }

  @Test
  void updateStudentInfo() {
  }

  @Test
  void deleteStudent() {
  }

  @Test
  void addProfessor() {
  }

  @Test
  void updateProfessorInfo() {
  }

  @Test
  void deleteProf() {
  }
}