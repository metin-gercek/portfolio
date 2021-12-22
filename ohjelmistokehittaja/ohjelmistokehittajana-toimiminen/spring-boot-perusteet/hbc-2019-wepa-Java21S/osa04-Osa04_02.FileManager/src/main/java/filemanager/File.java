package filemanager;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
public class File extends AbstractPersistable<Long>{
    
    private String name;
    private String contentType;
    private Long contentLength;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    
}
