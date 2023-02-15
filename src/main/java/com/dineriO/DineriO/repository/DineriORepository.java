package com.dineriO.DineriO.repository;

import com.dineriO.DineriO.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface DineriORepository extends CrudRepository <Restaurant, Long> {
}
