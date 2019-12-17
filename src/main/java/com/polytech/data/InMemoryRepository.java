package com.polytech.data;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Story> findAll(int skip, int limit) {
        ArrayList<Story> res = new ArrayList<Story>(this.memoryList.subList(skip, skip + limit));
        return res;
    }
}
