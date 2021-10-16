package com.bumdes.report.service;

import com.bumdes.report.model.AppUserDetail;
import com.bumdes.report.model.User;
import com.bumdes.report.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrId(s)
                .orElseThrow(() -> new UsernameNotFoundException("User tidak ditemukan"));

        return new AppUserDetail(user);
    }
}
