package com.cbnits.restapi.demoapplication.topics.controller;

import com.cbnits.restapi.demoapplication.topics.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cbnits.restapi.demoapplication.topics.entity.Topics;
import com.cbnits.restapi.demoapplication.topics.service.TopicsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("poo")
public class TopicsController{

    @Autowired
    private TopicsService topicsService;

    @GetMapping("/topics")
    public List<Topics> getAllTopics()
    {
        return topicsService.getservice();
    }

    @GetMapping("/topics/{id}")
    public Topics getATopic(@PathVariable String id) throws Exception {
        return topicsService.getAtopic(id);
    }

    @GetMapping(value = "/topics", params = {"name"})
    public List<Topics> getATopicbyname(@RequestParam("name") String name)
    {
        return topicsService.getAtopicbyname(name);
    }

    @PostMapping("/topics")
    public Response insertTopic(@RequestBody Topics topics) throws Exception {
        return topicsService.insertTopics(topics);
    }

    @PutMapping("/topics/{id}")
    public Response updateTopic(@RequestBody Topics topics, @PathVariable String id ) throws Exception {

        return topicsService.updateTopics(id,topics);
    }
    @DeleteMapping("/topics/{id}")
    public Response deleteTopic(@PathVariable String id) throws Exception {
        return topicsService.deleteTopic(id);
    }

}
