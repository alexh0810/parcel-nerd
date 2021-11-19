package com.example.parcelnerd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Parcel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @CsvBindByName
        private Long id;
        @CsvBindByName
        private String productName;
        @CsvBindByName
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate orderDate;
        @CsvBindByName
        private String address;
        @CsvBindByName
        private String customerName;
        @Enumerated(EnumType.STRING)
        @Column(name = "Status")
        @CsvBindByName
        private Status status;

        public Parcel() {}

        public Parcel(String productName, LocalDate orderDate, String address, String customerName, Status status) {
            super();
            this.productName = productName;
            this.orderDate = orderDate;
            this.address = address;
            this.customerName = customerName;
            this.status = status;
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

        public LocalDate getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {

            this.status = status;
        }

        @Override
        public String toString() {
            return "Package: id: " + id + ", Product: " + productName + ", Order date:" + orderDate + ", Address: " + address + ", Customer: " + customerName + "Status: " + this.getStatus();
        }

    }


