package com.cognizant.stockMarketCharting.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.stockMarketCharting.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.stockMarketCharting.authenticationservice.model.Role;
import com.cognizant.stockMarketCharting.authenticationservice.model.Users;
import com.cognizant.stockMarketCharting.authenticationservice.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	PasswordEncoder encoder;

	public AppUserDetailsService() {
		super();

	}

	public AppUserDetailsService(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUserName(username);
		System.out.println("uhgfyfgfghfhgfghhg ====>>>>"+user);
		UserDetails appUser = null;
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		} else {
			appUser = new AppUser(user);
		}
		return appUser;
	}

	@Transactional
	public boolean signup(Users user) throws UserAlreadyExistsException {
		boolean flag = false;
		if (usersRepository.findByUserName(user.getUserName()) != null) {
			flag = false;
			throw new UserAlreadyExistsException();

		} else {
			flag = true;
			Set<Role> roleList = new HashSet();
			roleList.add(new Role(1, "user"));
			user.setRoleList(roleList);
			usersRepository.save(user);
		}
		return flag;
	}
}