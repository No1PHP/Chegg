package chegg.controller;

import chegg.model.BO.ProfessorBO;
import chegg.model.BO.StudentBO;
import chegg.result.JSONResult;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * The interface User controller api.
 */
@RequestMapping("user")
public interface UserControllerApi {

  /**
   * Add student json result.
   *
   * @param studentBO the student bo
   * @param request   the request
   * @return the json result
   */
  @PostMapping("/addStudent")
  public JSONResult addStudent(@RequestBody @Valid StudentBO studentBO, HttpServletRequest request);

  /**
   * Update student json result.
   *
   * @param studentBO the student bo
   * @param request   the request
   * @return the json result
   */
  @PostMapping("/updateStudentInfo")
  public JSONResult updateStudentInfo(@RequestBody StudentBO studentBO, HttpServletRequest request);

  /**
   * List students json result.
   *
   * @param request the request
   * @return the json result
   */
  @GetMapping("/listStudents")
  public JSONResult listStudents(HttpServletRequest request);

  /**
   * Delete student json result.
   *
   * @param studentName the student name
   * @param request     the request
   * @return the json result
   */
  @GetMapping("/deleteStudent")
  public JSONResult deleteStudent(@RequestParam String studentName, HttpServletRequest request);

  /**
   * Add professor json result.
   *
   * @param professorBO the professor bo
   * @param request     the request
   * @return the json result
   */
  @GetMapping("/deleteProfessor")
  public JSONResult addProfessor(@RequestBody @Valid ProfessorBO professorBO,
      HttpServletRequest request);

  /**
   * Update professor info json result.
   *
   * @param professorBO the professor bo
   * @param request     the request
   * @return the json result
   */
  @PostMapping("/updateProfessorInfo")
  public JSONResult updateProfessorInfo(@RequestBody ProfessorBO professorBO,
      HttpServletRequest request);

  /**
   * List profs json result.
   *
   * @param request the request
   * @return the json result
   */
  @GetMapping("/listProfessors")
  public JSONResult listProfs(HttpServletRequest request);

  /**
   * Delete prof json result.
   *
   * @param profName the prof name
   * @param request  the request
   * @return the json result
   */
  @GetMapping("/deleteProfessor")
  public JSONResult deleteProf(@RequestParam String profName, HttpServletRequest request);

  /**
   * Gets student of school.
   *
   * @param schoolName the school name
   * @param request    the request
   * @return the student of school
   */
  @GetMapping("/findStudentsOfSchool")
  public JSONResult getStudentOfSchool(@RequestParam String schoolName, HttpServletRequest request);

  /**
   * Gets profs of school.
   *
   * @param schoolName the school name
   * @param request    the request
   * @return the profs of school
   */
  @GetMapping("/findProfsOfSchool")
  public JSONResult getProfsOfSchool(@RequestParam String schoolName, HttpServletRequest request);

  /**
   * Gets prof by course.
   *
   * @param courseName the course name
   * @param request    the request
   * @return the professors who taught this course
   */
  @GetMapping("/findCourseProf")
  public JSONResult getProfsByCourse(@RequestParam String courseName, HttpServletRequest request);

  /**
   * Gets prof with courses.
   *
   * @param request the request
   * @return the prof with courses
   */
  @GetMapping("/findprofWithCourses")
  public JSONResult getProfWithCourses(HttpServletRequest request);

  /**
   * Gets courses of prof.
   *
   * @param profName the prof name
   * @param request  the request
   * @return the taught courses of a professor
   */
  @GetMapping("/findCoursesOfProf")
  public JSONResult getCoursesOfProf(@RequestParam String profName, HttpServletRequest request);

  /**
   * Gets student by email.
   *
   * @param email   the email
   * @param request the request
   * @return the student name by email
   */
  @GetMapping("findStudentByEmail")
  public JSONResult getStudentByEmail(@RequestParam String email, HttpServletRequest request);

  /**
   * Gets prof by email.
   *
   * @param email   the email
   * @param request the request
   * @return the professor name by email
   */
  @GetMapping("findProfByEmail")
  public JSONResult getProfByEmail(@RequestParam String email, HttpServletRequest request);
}
