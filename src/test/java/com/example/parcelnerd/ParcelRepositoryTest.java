package com.example.parcelnerd;


import com.example.parcelnerd.domain.Parcel;
import com.example.parcelnerd.domain.ParcelRepository;
import com.example.parcelnerd.domain.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ParcelRepositoryTest {

    @Autowired
    private ParcelRepository repository;


    @Test
    public void findByCustomerNameShouldReturnParcel() {

        List<Parcel> parcels = repository.findByCustomerName("James Wand");
        assertThat(parcels.get(0).getProductName()).isEqualTo("Apple iPhone 13 Pro Max 1TB");
        assertThat(parcels.get(0).getOrderDate()).isEqualTo(LocalDate.of(2021, 10, 13));
        assertThat(parcels.get(0).getAddress()).isEqualTo("Pakkamestarinkatu 1D 52, 00500, Helsinki");

    }

    @Test
    public void createNewParcel() {
        Parcel parcel = new Parcel("Apple Airpods 3rd Gen (2021)", LocalDate.of(2021,11,17), "Suometsäntie 109", "Marko S Rahnasto", Status.SHIPPING);
        repository.save(parcel);
        assertThat(parcel.getId()).isNotNull();
    }
}
