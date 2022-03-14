package chegg.model.table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-13-17
 **/
@Getter
@Setter
@Table(name = "student")
public class Student extends User{
  @Id
  private long studentId;

}
