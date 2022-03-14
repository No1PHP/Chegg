package chegg.service;

import chegg.model.BO.ProfessorBO;
import chegg.model.BO.StudentBO;
import chegg.model.pojo.Course;
import chegg.model.pojo.ProfCourse;
import chegg.model.pojo.Professor;
import chegg.model.pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Zhining
 * @description
 * @create 2022-03-14-13-28
 **/
public class UserServiceImpl implements UserService{

  @Autowired
  private DataSource dataSource;

  @Override
  public List<Student> getStudentsBySchool(String schoolName) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    SELECT name, email, school\n"
        + "    FROM student\n"
        + "    WHERE school=?";
    PreparedStatement sl = connection.prepareStatement(query);
    sl.setString(1, schoolName);
    ResultSet resultSet = sl.executeQuery();
    List<Student> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");
      Student student = new Student(name, email, school);
      ans.add(student);
    }
    return ans;
  }

  @Override
  public List<Student> getStudents() throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    SELECT name, email, school\n"
        + "    FROM student\n";
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    List<Student> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");
      Student student = new Student(name, email, school);
      ans.add(student);
    }
    return ans;
  }

  @Override
  public List<Professor> getProfs() throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "SELECT name, email, school FROM professor;";
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    List<Professor> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");
      Professor professor = new Professor(name, email, school);
      ans.add(professor);
    }
    return ans;
  }

  @Override
  public List<Professor> getProfsBySchool(String schoolName) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    SELECT name, email, school\n"
        + "    FROM professor\n"
        + "    WHERE school=?";
    PreparedStatement sl = connection.prepareStatement(query);
    sl.setString(1, schoolName);
    ResultSet resultSet = sl.executeQuery();
    List<Professor> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");
      Professor prof = new Professor(name, email, school);
      ans.add(prof);
    }
    return ans;
  }


  @Override
  public List<ProfCourse> getProfWithCourses() throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "SELECT name, email, school FROM professor";
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    List<ProfCourse> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");

      String queryCourses = "      SELECT c.courseName\n"
          + "      FROM course c, (\n"
          + "        SELECT pc.courseId\n"
          + "        From professor_course pc, professor p\n"
            + "        where p.name= ? AND p.professorId=pc.professorId) as inline_view\n"
          + "      where c.courseId = inline_view.courseId;";
      PreparedStatement sl_courses = connection.prepareStatement(queryCourses);
      sl_courses.setString(1, name);
      ResultSet courses = sl_courses.executeQuery();
      List<String> coursesList = new ArrayList<>();

      while (courses.next()) {
        String courseName = courses.getString("courseName");
        coursesList.add(courseName);
      }

      ProfCourse profCourse = new ProfCourse(name, email, school, coursesList);
      ans.add(profCourse);
    }
    return ans;
  }


  @Override
  public List<Professor> getProfessorsByCourse(String courseName) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    Select p.name, p.email, p.school\n"
        + "    From professor p, (\n"
        + "      Select pc.professorId\n"
        + "      From professor_course pc, course c\n"
        + "      Where c.courseName = ? and c.courseId = pc.courseId) as inline_view\n"
        + "    Where p.professorId = inline_view.professorId;";
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    sl.setString(1, courseName);
    List<Professor> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      String email = resultSet.getString("email");
      String school = resultSet.getString("school");
      Professor professor = new Professor(name, email, school);
      ans.add(professor);
    }
    return ans;
  }

  @Override
  public List<String> getCoursesByProfessor(String professorName) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "      SELECT c.courseName\n"
        + "      FROM course c, (\n"
        + "        SELECT pc.courseId\n"
        + "        From professor_course pc, professor p\n"
        + "        where p.name= ? and p.professorId=pc.professorId) as inline_view\n"
        + "      where c.courseId = inline_view.courseId;";
    PreparedStatement sl = connection.prepareStatement(query);
    sl.setString(1, professorName);
    ResultSet resultSet = sl.executeQuery();
    List<String> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("courseName");
      ans.add(name);
    }
    return ans;
  }

  @Override
  public List<String> getStudentByEmail(String email) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    SELECT name\n"
        + "    FROM student\n"
        + "    WHERE email="+email;
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    List<String> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      ans.add(name);
    }
    return ans;
  }

  @Override
  public List<String> getProfessorByEmail(String email) throws SQLException {
    Connection connection = dataSource.getConnection();
    String query = "    SELECT name\n"
        + "    FROM student\n"
        + "    WHERE email="+email;
    PreparedStatement sl = connection.prepareStatement(query);
    ResultSet resultSet = sl.executeQuery();
    List<String> ans = new ArrayList<>();
    while (resultSet.next()) {
      String name = resultSet.getString("name");
      ans.add(name);
    }
    return ans;
  }

  @Override
  public boolean addStudent(StudentBO studentBO) {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      String update ="INSERT INTO student(name, email, school) "
          + "VALUES ("+studentBO.getName()+","+studentBO.getEmail()+","+studentBO.getSchool()+")";
      PreparedStatement sl = connection.prepareStatement(update);
      sl.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;

  }

  @Override
  public boolean updateStudentInfo(StudentBO studentBO) {
    Connection connection = null;
    if(studentBO.getName()==null) {
      //update is based on the student name
      return false;
    }
    try {
      connection = dataSource.getConnection();

      if(studentBO.getEmail()!=null) {
        String update ="UPDATE student set email= ? WHERE name=?";
        PreparedStatement up = connection.prepareStatement(update);
        up.setString(1, studentBO.getEmail());
        up.setString(2, studentBO.getName());
        up.executeUpdate();
      }
      if(studentBO.getSchool()!=null) {
        String update ="UPDATE student set school= ? WHERE name=?";
        PreparedStatement up = connection.prepareStatement(update);
        up.setString(1, studentBO.getSchool());
        up.setString(2, studentBO.getName());
        up.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean deleteStudent(String studentName) {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();

      String update ="DELETE FROM student WHERE name=?";
      PreparedStatement up = connection.prepareStatement(update);
      up.setString(1, studentName);
      up.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean addProfessor(ProfessorBO professorBO) {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      String update ="INSERT INTO student(name, email, school) "
          + "VALUES ("+professorBO.getName()+","+professorBO.getEmail()+","+professorBO.getSchool()+")";
      PreparedStatement sl = connection.prepareStatement(update);
      sl.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean updateProfessorInfo(ProfessorBO professorBO) {
    Connection connection = null;
    if(professorBO.getName()==null) {
      //update is based on the professor name
      return false;
    }
    try {
      connection = dataSource.getConnection();

      if(professorBO.getEmail()!=null) {
        String update ="UPDATE student set email= ? WHERE name=?";
        PreparedStatement up = connection.prepareStatement(update);
        up.setString(1, professorBO.getEmail());
        up.setString(2, professorBO.getName());
        up.executeUpdate();
      }
      if(professorBO.getSchool()!=null) {
        String update ="UPDATE student set school= ? WHERE name=?";
        PreparedStatement up = connection.prepareStatement(update);
        up.setString(1, professorBO.getSchool());
        up.setString(2, professorBO.getName());
        up.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public boolean deleteProf(String profName) {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();

      String update ="DELETE FROM student WHERE name=?";
      PreparedStatement up = connection.prepareStatement(update);
      up.setString(1, profName);
      up.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
