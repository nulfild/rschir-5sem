package ru.nulfild.courseWork5sem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nulfild.courseWork5sem.Entities.PlanEntity;
import ru.nulfild.courseWork5sem.Entities.UserEntity;
import ru.nulfild.courseWork5sem.Repositories.PlanRepo;

@Service
public class PlanService {
    @Autowired
    private PlanRepo planRepo;

    public PlanEntity createPlan(PlanEntity planEntity) {
        return planRepo.save(planEntity);
    }
    public PlanEntity getOne(Long id) throws Exception {
        PlanEntity planEntity = planRepo.findById(id).get();
        if (planEntity == null) {
            throw new Exception("Пользователя с таким id не существует");
        }
        return planEntity;
    }
}
