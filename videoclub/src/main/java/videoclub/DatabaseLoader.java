package videoclub;
import javax.annotation.PostConstruct;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private FilmRepository filmRepository;

    @PostConstruct
    private void initDatabase() {
        // USER-ROLE users
        GrantedAuthority[] userRoles = {
                new SimpleGrantedAuthority("ROLE_USER") };
        userRepository.save(new User("mateo", "macimatemago", "macimatemago@gmail.com", Arrays.asList(userRoles)));
        userRepository.save(new User("ramon", "rslnautic", "rslnautic@gmail.com", Arrays.asList(userRoles)));

        // ADMIN-ROLE users
        GrantedAuthority[] adminRoles = {
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN") };
        userRepository.save(new User("roberto", "bleh", "roberfrias115@gmail.com", Arrays.asList(adminRoles)));
        userRepository.save(new User("sergio", "hola", "sergio-rosello@hotmail.com", Arrays.asList(adminRoles)));
        
    }

}
