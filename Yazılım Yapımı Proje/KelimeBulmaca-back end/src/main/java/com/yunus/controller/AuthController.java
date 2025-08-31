package com.yunus.controller;
import com.yunus.controller.SignUpRequest;
import com.yunus.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3002")
public class AuthController {


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) { // SignUpRequest modelinizin adı farklı olabilir
        System.out.println("Alınan Kayıt İsteği:");
        System.out.println("Kullanıcı Adı: " + signUpRequest.getUsername());

        return ResponseEntity.ok("Kullanıcı başarıyla kaydedildi!"); // Örnek yanıt
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
        System.out.println("Alınan Giriş İsteği:");
        System.out.println("Kullanıcı Adı: " + loginDTO.getUsername());
        System.out.println("Şifre: [GİZLİ]");
        if ("testuser".equals(loginDTO.getUsername()) && "password".equals(loginDTO.getPassword())) {
            return ResponseEntity.ok("Giriş başarılı! (Placeholder - Gerçek kimlik doğrulama yakında!)");
        } else {
            return ResponseEntity.status(401).body("Kullanıcı adı veya şifre hatalı (Placeholder)");
        }


    }
}


