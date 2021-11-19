package com.example.parcelnerd.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {
    @Autowired
    ParcelRepository repository;

    public List<Parcel> fetchAll() {
        return (List<Parcel>) repository.findAll();
    }


}
