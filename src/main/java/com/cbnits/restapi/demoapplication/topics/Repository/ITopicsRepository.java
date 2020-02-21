package com.cbnits.restapi.demoapplication.topics.Repository;

import com.cbnits.restapi.demoapplication.topics.entity.Topics;

import java.util.List;
import java.util.Optional;

public interface ITopicsRepository {
    List<Topics> getService();
    public boolean insertTopics(Topics topic);
    public Topics updateTopics(String id, Topics topics1);
    public boolean deleteTopic(String id);

    Optional<Topics> getaTopic(String id);

    List<Topics> getaTopicbyname(String name);
}
