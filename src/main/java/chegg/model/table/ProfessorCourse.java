package chegg.model.table;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "professor_course")
public class ProfessorCourse {
  private String professorId;

  private String courseId;
}
