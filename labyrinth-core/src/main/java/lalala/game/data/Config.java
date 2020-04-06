package data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Map;

@JsonAutoDetect
@Data
public class Config {
    Map<String, String> levels;
}
