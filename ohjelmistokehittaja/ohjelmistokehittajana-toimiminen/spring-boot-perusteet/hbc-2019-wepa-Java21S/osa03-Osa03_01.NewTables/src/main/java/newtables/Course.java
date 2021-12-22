package newtables;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AbstractPersistable<Long> {

    public String name;
    @ManyToMany()
    @JoinTable(
        name = "Enrollment",
        joinColumns
        = @JoinColumn(name = "course_id", referencedColumnName = "id"),
        inverseJoinColumns
        = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    List<Student> students = new ArrayList<>();
}