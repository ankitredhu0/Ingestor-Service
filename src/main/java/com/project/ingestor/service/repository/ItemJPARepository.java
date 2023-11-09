package com.project.ingestor.service.repository;

import com.project.ingestor.service.entity.ItemRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJPARepository extends JpaRepository<ItemRecord, Long> {
}
