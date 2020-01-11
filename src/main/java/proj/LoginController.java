package proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String aa(Model model) {
        model.addAttribute("userReg", new User());
        model.addAttribute("userLog", new User());
        return "login";
    }

    @PostMapping("/login")
    public String a(@RequestParam(value = "param") String param, User user, Model model) {

        if (param.equals("signup")) {

            userRepository.save(user);

        }
        if (param.equals("signin")) {
            User u = userRepository.findByUsername(user.getUsername());


        }
        model.addAttribute("userReg", new User());
        model.addAttribute("userLog", new User());
        return "login";
    }


}