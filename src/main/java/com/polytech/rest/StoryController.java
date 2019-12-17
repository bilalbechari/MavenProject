package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepository;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class StoryController extends HttpServlet {

    InMemoryRepository storyRepository = new InMemoryRepository();
    PublicationService publicationService=new PublicationService(storyRepository);;

    @PostMapping("/stories")
    public void share(@RequestBody String content){
        publicationService.share(new Story(content));
    }

    @GetMapping("/stories")
    public ArrayList<Story> fetchAll(){
        return publicationService.fetchAll();
    }
}
