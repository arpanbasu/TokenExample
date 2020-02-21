package com.cbnits.restapi.demoapplication.topics.service;

import com.cbnits.restapi.demoapplication.topics.Repository.TopicsRepository;
import com.cbnits.restapi.demoapplication.topics.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cbnits.restapi.demoapplication.topics.entity.Topics;

import java.util.List;
import java.util.Optional;

@Service
public class TopicsService implements ITopicsService{

    @Autowired
    private TopicsRepository repository;
    @Override
    public List<Topics> getservice()
    {
        return repository.getService();
    }


    @Override
    public Topics getAtopic(String id) throws Exception {
        Optional<Topics> topicsOptional = repository.getaTopic(id);
        if (topicsOptional.isPresent())
            return topicsOptional.get();

        throw new Exception(String.format("Employee with id: %s not preset", id));
    }

    @Override
    public List<Topics> getAtopicbyname(String name) {
        return repository.getaTopicbyname(name);
    }

    @Override
    public Response insertTopics(Topics topic) throws Exception {
       boolean response = repository.insertTopics(topic);
       if (response)
           return new Response(true, String.format("Employee successfully added"));

        throw new Exception(String.format("Employee not successfully added"));
    }

    @Override
    public Response updateTopics(String id, Topics topics1) throws Exception {
        Topics update = repository.updateTopics(id, topics1);
        if (update !=null)
            return new Response(true, String.format("Employee with id: %s successfully updated.", id));

        throw new Exception(String.format("Employee with id: %s not preset", id));

    }

    @Override
    public Response deleteTopic(String id) throws Exception {
        boolean delete = repository.deleteTopic(id);
        if (delete)
            return new Response(false, String.format("Employee with id: %s successfully deleted.", id));

        throw new Exception(String.format("Employee with id: %s not preset", id));
    }


}
