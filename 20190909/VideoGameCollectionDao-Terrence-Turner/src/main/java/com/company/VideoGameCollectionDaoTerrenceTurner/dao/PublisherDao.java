package com.company.VideoGameCollectionDaoTerrenceTurner.dao;

import com.company.VideoGameCollectionDaoTerrenceTurner.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);
}
