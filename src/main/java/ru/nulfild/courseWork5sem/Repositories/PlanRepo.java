package ru.nulfild.courseWork5sem.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nulfild.courseWork5sem.Entities.PlanEntity;

public interface PlanRepo extends CrudRepository<PlanEntity, Long> {
}
