package com.geekster.Assignment.Stocks_Project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Stock {
    @Id   //Use ad Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)  //use to auto Increament in ID
    private Integer stock_Id;
    //@Column(unique = true)
    private String stockName;
    private Double stockPrice;
    private Integer stockOwnerCount;
    private String stockType;
    private Double stockMarketCap;
    private LocalDateTime stockBirthTimeStamp;
}
