package com.example.parcelnerd.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PackageRepository extends CrudRepository<Package, Long> {

    List<Package> findByCustomerName(@Param("customerName") String customerName);


}
