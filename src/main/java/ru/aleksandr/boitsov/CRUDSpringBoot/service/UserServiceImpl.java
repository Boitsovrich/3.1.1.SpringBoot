package ru.aleksandr.boitsov.CRUDSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aleksandr.boitsov.CRUDSpringBoot.model.Role;
import ru.aleksandr.boitsov.CRUDSpringBoot.model.User;
import ru.aleksandr.boitsov.CRUDSpringBoot.repository.RoleRepository;
import ru.aleksandr.boitsov.CRUDSpringBoot.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, RoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    @Override
    public <S extends User> S save(S user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }


    @Transactional(readOnly = true)
    @Override
    public Iterable findAll() {
        return userRepository.findAll();
    }


    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
