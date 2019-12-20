package com.polytech.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepositoryJPA extends JpaRepository<Story, Long> {

    
}
