package com.example.student;

import com.example.student.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    private UserService userService;
    private ApplicationEventPublisher applicationEventPublisher;
    private UserRepository userRepository;

    @Autowired
    public RegisterController(UserService userService,
                              ApplicationEventPublisher applicationEventPublisher,
                              UserRepository userRepository) {
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
        this.userRepository = userRepository;
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute UserModel userModel
            , BindingResult result, RedirectAttributes redirectAttributes) {
//        User user = userService.registerUser(userModel);
        userService.registerUser(userModel);
        redirectAttributes.addFlashAttribute("message", "Failed to register user");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        if (result.hasErrors()) {
            return "redirect:/";
        }
        User loaduser = userRepository.findUserByUsername(userModel.getUsername());
        if(loaduser!= null){
            redirectAttributes.addFlashAttribute("message", "" +
                    "username is not availailable as user with the same username already exsists in the db \n" +
                    " To Successfully register a new user try tryping another username as username must be unique !");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }
        else{
            redirectAttributes.addFlashAttribute("message", "Successfully registered new user");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        }

        return "redirect:/";
    }

    @GetMapping("/logoutSuccess")
    public  String logoutFail(){
        return "logout_success";
    }

    @GetMapping("/login?error")
    public  String logoutSucess(){
        return "logout_success";
    }

    @GetMapping("/failedLogin")
    public  String loginFail(){
        return "logout_success";
    }

//    @PostMapping(value = "/registerUser",consumes = "JASON")
//    public String registerUser( @RequestBody UserModel userModel){
//        User user =userService.registerUser(userModel);
////        publisher.publishEvent(new RegistrationCompleteEvent(
////                user,
////                applicationUrl(request)
////        ));
//        return "success_register";
//    }

//    private String applicationUrl(HttpServletRequest request) {
//        return "http://"+
//                request.getServerName()+
//                ":"+
//                request.getServerPort()+
//                request.getContextPath();
//    }

    @GetMapping("/fail")
    public String showFormpagex(){
        return "failed";
    };

    @GetMapping("/registerView")
    public String viewRegister(@ModelAttribute UserModel userModel){
        return  "register_user_form";
    }


}
