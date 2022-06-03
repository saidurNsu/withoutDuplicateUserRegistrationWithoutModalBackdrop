package com.example.student;
import com.example.student.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserModel userModel) {
        com.example.student.User loaduser = userRepository.findUserByUsername(userModel.getUsername());
        if(loaduser == null){
            User user = new User();
            user.setId(userModel.getId());
            user.setUsername(userModel.getUsername());
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            user.setDepartment(userModel.getDepartment());
            user.setRole("USER");
            userRepository.save(user);
        }
        else{
         System.out.println("username is not availailable as user with the same username" +
                 "already exsists in the db");
        }
    }

//    @Override
//    public User registerUser(UserModel userModel) {
//        com.example.student.User loaduser = userRepository.findUserByUsername(userModel.getUsername());
//
//        User user = new User();
//        user.setId(userModel.getId());
//        user.setUsername(userModel.getUsername());
//        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
//        user.setDepartment(userModel.getDepartment());
//        user.setRole("USER");
//        userRepository.save(user);
//       return user;
//    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken= new VerificationToken(token,user);
        verificationTokenRepository.save(verificationToken);
    }
}
