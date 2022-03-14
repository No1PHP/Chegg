package chegg.model.pojo;

import lombok.Data;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-14-04
 **/
@Data
public class Professor {
  private String professorId;

  private String name;

  private String email;

  private String school;

  public Professor(String name, String email, String school) {
    this.name = name;
    this.email = email;
    this.school = school;
  }
}
