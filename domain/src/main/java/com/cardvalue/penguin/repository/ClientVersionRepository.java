package com.cardvalue.penguin.repository;

import com.cardvalue.penguin.model.ClientVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guojia.chen on 2016-01-06 10:16.
 *
 * @Description:
 */
@Repository(value = "clientVersionRepository")
public interface ClientVersionRepository extends CrudRepository<ClientVersion, Integer> {
    public List<ClientVersion> findByType(String type);
}

