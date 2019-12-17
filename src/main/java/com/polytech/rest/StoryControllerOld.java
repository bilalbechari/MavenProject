package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepository;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet("/storiesOld")
public class StoryControllerOld extends HttpServlet {

    PublicationService publicationService;

    public StoryControllerOld(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    public void share(String content){
        publicationService.share(new Story(content));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoryRepository storyRepository = new InMemoryRepository();
        PublicationService publicationService = new PublicationService(storyRepository);
        StoryControllerOld storyController = new StoryControllerOld(publicationService);

        storyController.share("Marseille");
        storyController.share("Paris");
        storyController.share("Lyon");

        ArrayList<Story> allStories = publicationService.fetchAll();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String body = allStories.stream().map(story -> story.toString()).collect(Collectors.joining(","));
        out.println("[" + body + "]");
    }
}
