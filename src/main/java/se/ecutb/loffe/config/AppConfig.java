package se.ecutb.loffe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.ecutb.loffe.data.AppUserStorage;
import se.ecutb.loffe.data.AppUserStorageListImpl;

@Configuration
public class AppConfig {

    @Bean(name = "Funny name for a bean!")
    public AppUserStorage appUserStorage(){
        return new AppUserStorageListImpl();
    }
}
