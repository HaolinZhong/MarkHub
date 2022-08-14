package hz.blog.markerhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hz.blog.markerhub.mapper")
public class MarkerhubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkerhubApplication.class, args);
    }

}
