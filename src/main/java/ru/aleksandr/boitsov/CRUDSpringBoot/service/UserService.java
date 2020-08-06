package ru.aleksandr.boitsov.CRUDSpringBoot.service;


import ru.aleksandr.boitsov.CRUDSpringBoot.model.User;

public interface UserService {

    User findByLogin(String login);

    Iterable<User> findAll();

    public <S extends User> S save(S s);

    User findById(Long id);

    void deleteById(Long id);
}
