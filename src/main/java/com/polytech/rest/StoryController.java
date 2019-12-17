package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepository;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;
import org.springframework.web.bind.annotation.*;

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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class StoryController extends HttpServlet {

    InMemoryRepository storyRepository = new InMemoryRepository();
    PublicationService publicationService=new PublicationService(storyRepository);;

    @PostMapping("/stories")
    public void share(@RequestBody String content){
        publicationService.share(new Story(content));
    }

//    @GetMapping("/stories")
//    public ArrayList<Story> fetchAll(@RequestParam(value = "skip", defaultValue = "0") int skip, @RequestParam(value = "limit", defaultValue = "5") int limit){
//        return publicationService.fetchAll(skip, limit);
//    }

    @GetMapping("/stories")
    public ArrayList<Story> fetchAll(){
        return publicationService.fetchAll();
    }
}
