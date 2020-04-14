package lalala.game.core.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@JsonAutoDetect
@Data
public class LevelList {
    List<String> levels;
}
