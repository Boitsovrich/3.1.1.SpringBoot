package ru.aleksandr.boitsov.CRUDSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aleksandr.boitsov.CRUDSpringBoot.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
