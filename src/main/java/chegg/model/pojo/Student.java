package chegg.model.pojo;

import lombok.Data;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-14-05
 **/
@Data
public class Student {
  private String studentId;

  private String name;

  private String email;

  private String school;

  public Student(String name, String email, String school) {
    this.name = name;
    this.email = email;
    this.school = school;
  }
}
