package chegg.controller.impl;

import chegg.controller.UserControllerApi;
import chegg.model.BO.ProfessorBO;
import chegg.model.BO.StudentBO;
import chegg.model.pojo.ProfCourse;
import chegg.model.pojo.Professor;
import chegg.model.pojo.Student;
import chegg.result.JSONResult;
import chegg.service.UserService;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerApi {

  @Autowired
  private UserService userService;

  @Override
  public JSONResult addStudent(StudentBO studentBO, HttpServletRequest request) {
    boolean res = userService.addStudent(studentBO);
    if(res) {
      return JSONResult.ok();
    } else {
      return JSONResult.error();
    }
  }

  @Override
  public JSONResult updateStudentInfo(StudentBO studentBO, HttpServletRequest request) {
    boolean res = userService.updateStudentInfo(studentBO);
    if(res) {
      return JSONResult.ok();
    } else {
      return JSONResult.error();
    }
  }

  @Override
  public JSONResult listStudents(HttpServletRequest request) {
    List<Student> list = null;
    try {
      list = userService.getStudents();
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(list);
  }

  @Override
  public JSONResult deleteStudent(String studentName, HttpServletRequest request) {
    boolean res = userService.deleteStudent(studentName);
    if(res) {
      return JSONResult.ok();
    } else {
      return JSONResult.error();
    }
  }

  @Override
  public JSONResult addProfessor(ProfessorBO professorBO, HttpServletRequest request) {
    boolean res = userService.addProfessor(professorBO);
    if(res) {
      return JSONResult.ok();
    } else {
      return JSONResult.error();
    }
  }

  @Override
  public JSONResult updateProfessorInfo(ProfessorBO professorBO, HttpServletRequest request) {
    return null;
  }

  @Override
  public JSONResult listProfs(HttpServletRequest request) {
    List<Professor> list = null;
    try {
      list = userService.getProfs();
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(list);
  }

  @Override
  public JSONResult deleteProf(String profName, HttpServletRequest request) {
    boolean res = userService.deleteProf(profName);
    if(res) {
      return JSONResult.ok();
    } else {
      return JSONResult.error();
    }
  }

  @Override
  public JSONResult getStudentOfSchool(String schoolName, HttpServletRequest request) {
    List<Student> students = null;
    try {
      students = userService.getStudentsBySchool(schoolName);
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(students);
  }

  @Override
  public JSONResult getProfsOfSchool(String schoolName, HttpServletRequest request) {
    List<Professor> profs = null;
    try {
      profs = userService.getProfsBySchool(schoolName);
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(profs);
  }

  @Override
  public JSONResult getProfsByCourse(String courseName, HttpServletRequest request) {
    return null;
  }

  @Override
  public JSONResult getProfWithCourses(HttpServletRequest request) {
    List<ProfCourse> profCourses = null;
    try {
      profCourses = userService.getProfWithCourses();
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(profCourses);
  }

  @Override
  public JSONResult getCoursesOfProf(String profName, HttpServletRequest request) {
    List<Professor> professors = null;
    try {
      professors = userService.getProfessorsByCourse(profName);
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(professors);
  }

  @Override
  public JSONResult getStudentByEmail(String email, HttpServletRequest request) {
    List<String> list = null;
    try {
      list = userService.getStudentByEmail(email);
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(list);
  }

  @Override
  public JSONResult getProfByEmail(String email, HttpServletRequest request) {
    List<String> list = null;
    try {
      list = userService.getProfessorByEmail(email);
    } catch (SQLException e) {
      e.printStackTrace();
      return JSONResult.error();
    }
    return JSONResult.ok(list);
  }
}
