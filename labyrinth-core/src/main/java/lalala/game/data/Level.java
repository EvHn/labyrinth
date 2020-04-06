package data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@JsonAutoDetect
@Data
public class Level {
    private String name;
    private int height;
    private int width;
    private List<List<Character>> field;
}
