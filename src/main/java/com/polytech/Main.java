package com.polytech;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepository;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Instantiate and inject dependencies...
        StoryRepository storyRepository = new InMemoryRepository();
        PublicationService publicationService = new PublicationService(storyRepository);
        StoryController storyController = new StoryController(publicationService);

        //Simulate HTTP calls
        storyController.share("Marseille");
        storyController.share("Paris");
        storyController.share("Lyon");

        ArrayList<Story> allStories = publicationService.fetchAll();

        for (Story s : allStories)
            System.out.println(s.toString());
    }
}
