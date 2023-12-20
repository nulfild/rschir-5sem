package ru.nulfild.courseWork5sem.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.nulfild.courseWork5sem.Entities.HouseEntity;

public interface HouseRepo extends CrudRepository<HouseEntity, Long> {
}
