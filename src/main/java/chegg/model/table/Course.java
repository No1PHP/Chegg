package chegg.model.table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-13-55
 **/
@Table(name = "course")
@Getter
@Setter
public class Course {

  private String professorId;

  private String courseName;

}
