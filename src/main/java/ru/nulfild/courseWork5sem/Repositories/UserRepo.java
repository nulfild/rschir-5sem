package ru.nulfild.courseWork5sem.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nulfild.courseWork5sem.Entities.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
