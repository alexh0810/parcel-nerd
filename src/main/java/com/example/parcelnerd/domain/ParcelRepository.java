package com.example.parcelnerd.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ParcelRepository extends CrudRepository<Parcel, Long> {

        List<Parcel> findByCustomerName(@Param("customerName") String customerName);

}
