package com.project.ingestor.service.repository;

import com.project.ingestor.service.entity.ItemRecord;
import com.project.ingestor.service.model.ItemRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ItemRepositoryTest {

    @Test
    public void testSaveItemSuccessfully() {
        // Create a mock ItemJPARepository
        ItemJPARepository mockRepo = Mockito.mock(ItemJPARepository.class);

        // Create a test ItemRepository with the mock repository
        ItemRepository itemRepository = new ItemRepository(mockRepo);

        // Create a mock ItemRequest
        ItemRequest itemRequest = new ItemRequest(/* initialize with required data */);

        // Define the behavior of the mock repository's save method
        Mockito.when(mockRepo.save(Mockito.any(ItemRecord.class))).thenReturn(new ItemRecord());

        // Call the save method
        itemRepository.save(itemRequest);

        // Verify that the save method of the mock repository was called
        Mockito.verify(mockRepo, Mockito.times(1)).save(Mockito.any(ItemRecord.class));

        // Add additional assertions as needed
    }

}
