package com.polytech.data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcRepository implements StoryRepository {

    private DataSource dataSource;

    public JdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Story story) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO story(content) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, story.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Story> findAll() {
        ArrayList<Story> storyArrayList = new ArrayList<Story>();
        try {
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM story";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                storyArrayList.add(new Story(resultSet.getString("content")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return storyArrayList;
    }

    @Override
    public ArrayList<Story> findAll(int skip, int limit) {
        return null;
    }
}
