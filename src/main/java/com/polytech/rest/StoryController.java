package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.JdbcRepository;
import com.polytech.data.Story;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class StoryController extends HttpServlet {

    private PublicationService publicationService;

    @Autowired
    public StoryController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

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
