package proj;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/newsitem").setViewName("newsitem");
        registry.addViewController("/contacts").setViewName("contacts");
        registry.addViewController("/send_message").setViewName("send_message");
        registry.addViewController("/admin").setViewName("admin");
        //registry.addViewController("/catalog").setViewName("catalog");
        //registry.addViewController("/edit_subtables").setViewName("edit_subtables");
    }

}
