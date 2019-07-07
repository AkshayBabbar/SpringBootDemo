package com.Starter.SpringDemo.repositories;

import com.Starter.SpringDemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
