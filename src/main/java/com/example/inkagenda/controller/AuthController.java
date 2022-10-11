package com.example.inkagenda.controller;

import com.example.inkagenda.dto.AuthenticationResponse;
import com.example.inkagenda.dto.LoginRequest;
import com.example.inkagenda.dto.RefreshTokenRequest;
import com.example.inkagenda.dto.RegisterRequest;
import com.example.inkagenda.service.AuthService;
import com.example.inkagenda.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;



    @PostMapping("/signup")
   // @CrossOrigin(origins = "http://localhost:19006")
    public  ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Sucessful", HttpStatus.OK);
     }

     @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Sucessfully", HttpStatus.OK);
     }


     @PostMapping("/login")
    // @CrossOrigin(origins = "http://localhost:19006")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
         return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    //@CrossOrigin(origins = "http://localhost:19006")
    public ResponseEntity<String>  logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Sucessfully");

    }

}
