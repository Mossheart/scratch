package junit5_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("junit5_sample")
@PropertySource(value={"classpath:application.properties"})
@EnableAutoConfiguration
public class Application
{
    public static void  main(String[] args) throws  ClassNotFoundException
    {
        SpringApplication.run(Application.class, args);
    }
}
