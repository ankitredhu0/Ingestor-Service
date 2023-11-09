package com.project.ingestor.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ingestor.service.model.ItemRequest;
import com.project.ingestor.service.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ItemConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ItemConsumer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ItemRepository databaseService;

    @KafkaListener(topics = "${spring.kafka.ingestor.topic}" ,containerFactory = "itemListenerContainerFactory")
    public void consumeMatcherAuditMessage(@Payload String message) {

        try {
            ItemRequest itemRequest = objectMapper.readValue(message, ItemRequest.class);
            logger.info("Received new Item Request : {}", itemRequest);
            databaseService.save(itemRequest);

        } catch (JsonProcessingException ex) {
            logger.info("Error in consuming item: {}", ex.getLocalizedMessage());
        }
    }
}
