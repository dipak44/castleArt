//// uncomment this code to apply the spring security to your project
//package com.castleArt.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.castleArt.dao.CustomerRepository;
//import com.castleArt.entities.Customer;
//
//public class CustomerDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private CustomerRepository custrepo;
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		Customer customer = custrepo.getCustomerByUsername(username);
//
//		if (customer == null) {
//			throw new UsernameNotFoundException("Could not find user");
//		}
//
//		return new CustomUserDetails(customer);
//	}
//
//}
