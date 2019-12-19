package com.polytech.business;

import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class PublicationService {

    private StoryRepository storyRepository;

    public PublicationService(StoryRepository storyRepository){
        this.storyRepository = storyRepository;
    }

    public void share(Story story){
        storyRepository.save(story);
    }

    public ArrayList<Story> fetchAll(){
        return storyRepository.findAll();
    }

    public ArrayList<Story> fetchAll(int skip, int limit){
        return storyRepository.findAll(skip, limit);
    }
}
