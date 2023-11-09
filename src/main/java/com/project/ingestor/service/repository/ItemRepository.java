package com.project.ingestor.service.repository;

import com.project.ingestor.service.entity.ItemRecord;
import com.project.ingestor.service.model.ItemRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemRepository {

    private static final Logger logger = LoggerFactory.getLogger(ItemRepository.class);

    private final ItemJPARepository repo;

    @Autowired
    public ItemRepository(ItemJPARepository repo) {
        this.repo = repo;
    }
    public void save(ItemRequest itemRequest) {

        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        try {
            ItemRecord itemRecord = ItemRecord.builder()
                    .id(id)
                    .itemCategory(itemRequest.getItemCategory())
                    .itemName(itemRequest.getName())
                    .mediaUrl(itemRequest.getMediaUrl())
                    .condition(itemRequest.getCondition())
                    .description(itemRequest.getDescription())
                    .basePrice(itemRequest.getBasePrice())
                    .auctionSlot(itemRequest.getAuctionSlot())
                    .buyingYear(itemRequest.getBuyingYear())
                    .build();

            repo.save(itemRecord);
            logger.info("Item got saved successfully in Postgres : {} ", itemRecord);

        }catch(Exception ex){
            logger.error("Error while saving the Item in DB : {} ", ex.getLocalizedMessage());
        }

    }
}
