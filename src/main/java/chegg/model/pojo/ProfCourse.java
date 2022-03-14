package chegg.model.pojo;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfCourse extends Professor{

  private List<String> courses;

  public ProfCourse(String name, String email, String school,
      List<String> courses) {
    super(name, email, school);
    this.courses = courses;
  }

  public ProfCourse(String name, String email, String school) {
    super(name, email, school);
  }


}
