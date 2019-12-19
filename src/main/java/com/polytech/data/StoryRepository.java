package com.polytech.data;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StoryRepository {

    void save(Story story);
    ArrayList<Story> findAll();
    ArrayList<Story> findAll(int skip, int limit);
}