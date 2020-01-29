package se.ecutb.loffe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.loffe.config.AppConfig;
import se.ecutb.loffe.data.AppUserStorage;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        AppUserStorage storage = context.getBean(AppUserStorage.class);
        System.out.println(storage.createAppUser("Nisse", "Nys", "nisse@nys.com"));

    }
}
