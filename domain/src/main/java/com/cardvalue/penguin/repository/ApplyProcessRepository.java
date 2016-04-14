package com.cardvalue.penguin.repository;


import com.cardvalue.penguin.model.ApplyProcess;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplyProcessRepository extends CrudRepository<ApplyProcess, Integer>,ApplyProcessRepositoryCustom{
	public List<ApplyProcess> findByProcessType(int processType);
}
