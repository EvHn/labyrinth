package lalala.game.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("lalala.game.web")
public class WebConfig implements WebMvcConfigurer {
}
