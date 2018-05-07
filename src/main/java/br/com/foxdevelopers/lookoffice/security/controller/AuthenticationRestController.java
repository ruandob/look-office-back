package br.com.foxdevelopers.lookoffice.security.controller;

import javax.servlet.http.HttpServletRequest;

import br.com.foxdevelopers.lookoffice.core.controller.ResponseAbstractController;
import br.com.foxdevelopers.lookoffice.domain.pessoa.Pessoa;
import br.com.foxdevelopers.lookoffice.domain.pessoa.PessoaService;
import br.com.foxdevelopers.lookoffice.security.jwt.JwtAuthenticationRequest;
import br.com.foxdevelopers.lookoffice.security.jwt.JwtTokenUtil;
import br.com.foxdevelopers.lookoffice.security.model.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController extends ResponseAbstractController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value="/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getSenha()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final Pessoa user = pessoaService.findByEmail(authenticationRequest.getEmail());
        return ResponseEntity.ok(new CurrentUser(token, user));
    }

    @PostMapping(value="/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = jwtTokenUtil.getUsernameFromToken(token);
        final Pessoa user = pessoaService.findByEmail(username);
        
        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new CurrentUser(refreshedToken, user));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@RequestBody Pessoa pessoa){
        pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
        return jsonResponse(pessoaService.save(pessoa));

    }



}
