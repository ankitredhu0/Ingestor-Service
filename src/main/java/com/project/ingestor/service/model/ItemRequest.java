package com.project.ingestor.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {

    private String name;
    private String description;
    private String mediaUrl;
    private String itemCategory;
    private Timestamp auctionSlot;
    private Long basePrice;
    private String condition;
    private String buyingYear;
}
