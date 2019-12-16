package com.polytech.business;

import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

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
}
