package com.example.parcelnerd.domain;

import javax.persistence.*;

@Entity
public class Parcel {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String productName;
        private String orderDate;
        private String address;
        private String customerName;
        @Enumerated(EnumType.STRING)
        @Column(name = "Status")
        private Status status;

        public Parcel() {}

        public Parcel(String productName, String orderDate, String address, String customerName, Status status) {
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


