package tech.immo.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.exceptions.TokenRefreshException;
import tech.immo.maintenance.models.RefreshToken;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.models.UserData;
import tech.immo.maintenance.services.RefreshTokenService;
import tech.immo.maintenance.services.UserService;
import tech.immo.maintenance.utils.JwtResponse;
import tech.immo.maintenance.utils.JwtUtils;
import tech.immo.maintenance.utils.TokenRefreshRequest;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    //private AuthenticationManager authenticationManager;
    private RefreshTokenService refreshTokenService;

    public UserController(UserService userService) {
        this.userService = userService;
       // this.authenticationManager = authenticationManager;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") int id) {
        User user= userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<User> addUser(@RequestBody User userData) {
        User user = userService.addUser(userData);
        if(user !=  null ) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.resolve(500));
        }

    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User userData) {
        User user = userService.updateUser(userData);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<User> doLogin(@RequestParam String email, @RequestParam String password ) {
        User user = userService.doLogin(password, email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

   // public ResponseEntity<?> authenticateUser(@RequestParam String email, @RequestParam String password) {

    //    Authentication authentication = authenticationManager
     //           .authenticate(new UsernamePasswordAuthenticationToken(email, password));

     //   SecurityContextHolder.getContext().setAuthentication(authentication);

     //   UserData userDetails = (UserData) authentication.getPrincipal();

     //   String jwt = JwtUtils.generateJwtToken(userDetails);

    //    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

     //   return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
     //           userDetails.getEmail(), userDetails.getEmail(), roles));
  //  }

  //  @PostMapping("/refreshtoken")
   // public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {
    //    String requestRefreshToken = request.getRefreshToken();

  //      return refreshTokenService.findByToken(requestRefreshToken)
   //             .map(refreshTokenService::verifyExpiration)
  //              .map(RefreshToken::getUser)
  //              .map(user -> {
  //                  String token = JwtUtils.generateTokenFromUsername(user.getEmail());
   //                 return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
    //            })
    //            .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
     //                   "Refresh token is not in database!"));
    //}


}
