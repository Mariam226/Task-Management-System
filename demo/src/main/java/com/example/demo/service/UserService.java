package com.example.demo.service;
import com.example.demo.classesPackage.Task;
import com.example.demo.classesPackage.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;
   public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
       this.userRepository=userRepository;
       this.passwordEncoder=passwordEncoder;
   }
  public User login(String password,String gmail){
       User user=userRepository.findByGmail(gmail);
       if(user!=null&& passwordEncoder.matches(password, user.getPassword())){
           return user;
    }
       else{
           return null;
       }
  }
   public void signup(String password,String gmail){
       if(userRepository.findByGmail(gmail)==null) {
           User user = new User();
           user.setGmail(gmail);
           user.setPassword(passwordEncoder.encode(password));
           userRepository.save(user);
       }       //search to see that user already exist or no
   }
}
