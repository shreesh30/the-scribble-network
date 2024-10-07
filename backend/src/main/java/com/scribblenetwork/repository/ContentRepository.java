package com.scribblenetwork.repository;

import com.scribblenetwork.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

    @Query("SELECT c from ContentEntity c WHERE c.id=:id")
    ContentEntity findById(@Param("id") String id);
}
