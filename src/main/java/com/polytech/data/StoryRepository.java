package com.polytech.data;

import java.util.ArrayList;

public interface StoryRepository {

    void save(Story story);
    ArrayList<Story> findAll();
}
