package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.Story;

public class StoryController {

    PublicationService publicationService;

    public StoryController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    public void share(String content){
        publicationService.share(new Story(content));
    }
}
