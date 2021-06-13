/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.quasar.Quasar;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zw.co.quasar.Quasar.Services.AccountService;

/**
 *
 * @author Mabhena
 */
@Component
public class QuasarAuthenticationProvider implements AuthenticationProvider{
    @Autowired
    AccountService accountService;
    
    //todo restore bcrypt
    //private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
    
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        String passwordHash = accountService.getUserPasswordHash(username);
        if(passwordHash == null){
            System.out.println("Password hash is null");
            throw new BadCredentialsException(
"                       Authentication failed for " + username);
        }
        if(!passwordEncoder.matches(password, passwordHash)){
            System.out.println("Password does not match");
            throw new BadCredentialsException(
                "Authentication failed for " + username);
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("CUSTOMER"));
        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
        UsernamePasswordAuthenticationToken.class);
    } 
}
