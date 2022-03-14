package chegg.model.BO;

import lombok.Data;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-14-05
 **/
@Data
public class StudentBO {
  private String studentId;

  private String name;

  private String email;

  private String school;
}
