package github.akanemiku.springbootinterceptorfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootInterceptorFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInterceptorFilterApplication.class, args);
    }

}
