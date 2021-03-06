//package com.project.shoppingcart.service.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//	UserRepository repository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = repository.findByUsername(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("Check the username");
//		}
//		return new UserDetailsImpl(user);
//	}
//
//}
