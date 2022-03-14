package chegg.service;

import chegg.model.BO.ProfessorBO;
import chegg.model.BO.StudentBO;
import chegg.model.pojo.Course;
import chegg.model.pojo.ProfCourse;
import chegg.model.pojo.Professor;
import chegg.model.pojo.Student;
import java.sql.SQLException;
import java.util.List;

/**
 * The interface User service.
 *
 * @author Zhining
 * @description
 * @create 2022 -03-13-15-18
 */
public interface UserService {

  /**
   * Gets students by school.
   *
   * @param schoolName the school name
   * @return the students by school
   * @throws SQLException the sql exception
   */
  public List<Student> getStudentsBySchool(String schoolName) throws SQLException;

  /**
   * Gets students.
   *
   * @return the students
   * @throws SQLException the sql exception
   */
  public List<Student> getStudents() throws SQLException;

  /**
   * Gets profs.
   *
   * @return the profs
   * @throws SQLException the sql exception
   */
  public List<Professor> getProfs() throws SQLException;

  public List<Professor> getProfsBySchool(String schoolName) throws SQLException;

  public List<ProfCourse> getProfWithCourses() throws SQLException;
  /**
   * Gets professor by course.
   *
   * @param courseName the course name
   * @return the professor by course
   */
  public List<Professor> getProfessorsByCourse(String courseName) throws SQLException;

  /**
   * Gets courses by professor.
   *
   * @param professorName the professor name
   * @return the courses by professor
   */
  public List<String> getCoursesByProfessor(String professorName) throws SQLException;

  /**
   * Gets student by email.
   *
   * @param email the email
   * @return the student by email
   */
  public List<String> getStudentByEmail(String email) throws SQLException;

  /**
   * Gets professor by email.
   *
   * @param email the email
   * @return the professor by email
   */
  public List<String> getProfessorByEmail(String email) throws SQLException;

  /**
   * Add student.
   *
   * @param studentBO the student bo
   */
  public boolean addStudent(StudentBO studentBO);

  /**
   * Update student info.
   *
   * @param studentBO the student bo
   */
  public boolean updateStudentInfo(StudentBO studentBO);

  /**
   * Delete student.
   *
   * @param studentName the student name
   */
  public boolean deleteStudent(String studentName);

  /**
   * Add professor.
   *
   * @param professorBO the professor bo
   */
  public boolean addProfessor(ProfessorBO professorBO);

  /**
   * Update professor info.
   *
   * @param professorBO the professor bo
   */
  public boolean updateProfessorInfo(ProfessorBO professorBO);

  /**
   * Delete prof.
   *
   * @param profName the prof name
   */
  public boolean deleteProf(String profName);
}
