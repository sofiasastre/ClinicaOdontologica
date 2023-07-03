package com.example.ClinicaOdontologica.login;

import com.example.ClinicaOdontologica.modelo.AppUser;
import com.example.ClinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;


    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("Sofi");
        String password2 = passwordEncoder.encode("Augus");
        //Comento para que no se cree dos veces
        //userRepository.save(new AppUser("Sofia","Sastre","a@a.com",password,AppUsuarioRoles.ADMIN));
        //userRepository.save(new AppUser("Augusto","Drocchi","a@a.com",password2,AppUsuarioRoles.USER));

    }
}
