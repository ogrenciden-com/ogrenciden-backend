package com.ogrenciden.ogrenciden.Controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ogrenciden.ogrenciden.Business.UserService;
import com.ogrenciden.ogrenciden.Model.User;
import com.ogrenciden.ogrenciden.Request.UserLoginRequest;
import com.ogrenciden.ogrenciden.Request.UserRegisterRequest;
import com.ogrenciden.ogrenciden.Security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	
	public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			UserService userService, PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	public String login(@RequestBody UserLoginRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer " + jwtToken;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserRegisterRequest registerRequest) {
		if (userService.getOneUserByEmail(registerRequest.getEmail()) != null) {
			return new ResponseEntity<>("E-mail daha önceden alınmış.",HttpStatus.BAD_REQUEST);
		}
		if (registerRequest.getPassword().length() < 6) {
			return new ResponseEntity<>("Oluşturduğunuz şifre 6 karakterden büyük olmalıdır.",HttpStatus.BAD_REQUEST);
		}
		
		String regex = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@" + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(registerRequest.getEmail());
        if(!matcher.matches()) {
        	return new ResponseEntity<>("E-mail adresi e-mail formatına uygun olmalıdır. (example@example.com)",HttpStatus.BAD_REQUEST);
        }
        
        if(registerRequest.getName().length() < 1) {
        	return new ResponseEntity<>("İsim 1 karakterden uzun olmalıdır.",HttpStatus.BAD_REQUEST);
        }
        if (registerRequest.getLastName().length() < 1) {
        	return new ResponseEntity<>("Soyisim 1 karakterden uzun olmalıdır.",HttpStatus.BAD_REQUEST);
        }
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setLastName(registerRequest.getLastName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		userService.saveOneUser(user);
		return new ResponseEntity<>("Kayıt işlemi başarı ile tamamlandı.",HttpStatus.CREATED); 
	}	
}
