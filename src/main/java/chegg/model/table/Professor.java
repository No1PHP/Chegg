package chegg.model.table;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zhining
 * @description
 * @create 2022-03-13-13-52
 **/
@Getter
@Setter
@Table(name = "professor")
public class Professor extends User {
  @Id
  private long professorId;


}
