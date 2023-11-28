//AuthenticationService.java
package com.pizzaria.pizzaria_api.service;

import com.pizzaria.pizzaria_api.config.JwtServiceGenerator;
import com.pizzaria.pizzaria_api.dto.FuncionarioDTO;
import com.pizzaria.pizzaria_api.dto.LoginDTO;
import com.pizzaria.pizzaria_api.entity.Funcionario;
import com.pizzaria.pizzaria_api.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	@Autowired
	private JwtServiceGenerator jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;


	public FuncionarioDTO logar(LoginDTO loginDTO) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginDTO.getLogin(),
						loginDTO.getSenha()
						)
				);
		Funcionario user = repository.findByUsername(loginDTO.getLogin()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		
		return toFuncionaDTO(user, jwtToken);
	}


	private FuncionarioDTO toFuncionaDTO(Funcionario user, String token) {
		FuncionarioDTO userDTO = new FuncionarioDTO();
		userDTO.setId(user.getId());
		userDTO.setRole(user.getRole());
		userDTO.setToken(token);
		userDTO.setLogin(user.getUsername());
		return userDTO;
	}

}
