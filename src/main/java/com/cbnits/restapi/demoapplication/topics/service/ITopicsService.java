package com.cbnits.restapi.demoapplication.topics.service;

import com.cbnits.restapi.demoapplication.topics.Response;
import com.cbnits.restapi.demoapplication.topics.entity.Topics;

import java.util.List;
import java.util.Optional;

public interface ITopicsService {
    public List<Topics> getservice();

    Response insertTopics(Topics topics) throws Exception;

    Response updateTopics(String id, Topics topics) throws Exception;

    Response deleteTopic(String id) throws Exception;

    Topics getAtopic(String id) throws Exception;

    List<Topics> getAtopicbyname(String name);
}
