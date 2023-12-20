package ru.nulfild.courseWork5sem.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nulfild.courseWork5sem.Entities.UserEntity;
import ru.nulfild.courseWork5sem.Repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws Exception {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new Exception("Пользователь с таким именем уже сущесвует!");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws Exception {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new Exception("Пользователя с таким id не существует");
        }
        return user;
    }
}
