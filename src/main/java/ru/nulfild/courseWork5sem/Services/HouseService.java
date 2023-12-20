package ru.nulfild.courseWork5sem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nulfild.courseWork5sem.Entities.HouseEntity;
import ru.nulfild.courseWork5sem.Entities.PlanEntity;
import ru.nulfild.courseWork5sem.Entities.UserEntity;
import ru.nulfild.courseWork5sem.Repositories.HouseRepo;
import ru.nulfild.courseWork5sem.Repositories.PlanRepo;
import ru.nulfild.courseWork5sem.Repositories.UserRepo;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlanRepo planRepo;

    public HouseEntity createHouse(HouseEntity house, Long userId) throws Exception {
        UserEntity user = userRepo.findById(userId).get();
        if (user == null) {
            throw new Exception("Такого пользователя не существует!");
        }
        house.setUser(user);
        return houseRepo.save(house);
    }

    public HouseEntity buyPlan(Long houseId, Long planId) throws Exception {
        HouseEntity house = houseRepo.findById(houseId).get();
        PlanEntity plan = planRepo.findById(planId).get();

        if (house == null || plan == null) {
            throw new Exception("Проверьте правильность данных!");
        }

        house.setPlan(plan);
        return houseRepo.save(house);
    }

    public long getPrice(Long houseId, Long planId) throws Exception {
        HouseEntity house = houseRepo.findById(houseId).get();
        PlanEntity plan = planRepo.findById(planId).get();

        if (house == null || plan == null) {
            throw new Exception("Проверьте правильность данных!");
        }

        return plan.getMultiplier() * house.getNumOfRooms() * house.getSquare();
    }

    public List<HouseEntity> getAllHouses() {
        return (List<HouseEntity>) houseRepo.findAll();
    }
}
