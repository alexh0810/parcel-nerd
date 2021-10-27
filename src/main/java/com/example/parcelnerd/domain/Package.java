package com.example.parcelnerd.domain;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String orderDate;
    private String address;
    private String customerName;

    public Package() {}

    public Package(String productName, String orderDate, String address, String customerName) {
        super();
        this.productName = productName;
        this.orderDate = orderDate;
        this.address = address;
        this.customerName = customerName;
    }

    public Long getId() {
        return  id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Package: id: " + id + ", Product: " + productName + ", Order date:" + orderDate + ", Address: " + address + ", Customer: " + customerName;
    }

}
