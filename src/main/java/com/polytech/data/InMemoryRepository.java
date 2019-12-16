package com.polytech.data;

import java.util.ArrayList;

public class InMemoryRepository implements StoryRepository {

    private ArrayList<Story> memoryList;

    public InMemoryRepository() {
        this.memoryList = new ArrayList<Story>();
    }

    public void save(Story story) {
        this.memoryList.add(story);
    }

    public ArrayList<Story> findAll() {
        return this.memoryList;
    }
}
