package com.cbnits.restapi.demoapplication.topics.Repository;

import com.cbnits.restapi.demoapplication.topics.entity.Topics;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TopicsRepository implements ITopicsRepository {

    private List<Topics> topics =new ArrayList<>(Arrays.asList(
            new Topics(UUID.randomUUID().toString(),"Spring",212421,"Spring Description"),
            new Topics(UUID.randomUUID().toString(),"JavaScript",123654789,"JavaScript Description")));


    @Override
    public List<Topics> getService() {
        return topics;
    }

    @Override
    public Optional<Topics> getaTopic(String id) {

//        Topics newTopic = new Topics(null,null,null,null);
//        for (int j=0;j<topics.size();j++)
//        {
//            Topics fetchTopic = topics.get(j);
//            if (fetchTopic.getId().equals(id))
//            {
//                newTopic = fetchTopic;
//            }
//            else if (fetchTopic.getName().equals(id))
//            {
//                newTopic = fetchTopic;
//            }
//        }
        return topics.stream().filter(t->t.getId().equals(id)).findFirst();
       // return newTopic;
    }

    @Override
    public List<Topics> getaTopicbyname(String name) {
        return topics.stream().filter(topics1 -> topics1.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public boolean insertTopics(Topics topic) {
        Topics inserttopic = new Topics(
                UUID.randomUUID().toString(),
                topic.getName(),
                topic.getDuration(),
                topic.getDescription()
        );
        return topics.add(inserttopic);
    }

    @Override
    public Topics updateTopics(String id, Topics topics1) {

        Optional<Topics> optionalTopics= topics.stream().filter(topics2 -> topics2.getId().equals(id)).findFirst();
            if (optionalTopics.isPresent())
            {
                Topics topics2 = optionalTopics.get();
                topics2.setName(topics1.getName());
                topics2.setDescription(topics1.getDescription());
                topics2.setDuration(topics1.getDuration());
                return topics2;
            }

        return null;
    }

    @Override
    public boolean deleteTopic(String id) {
        topics.removeIf(t ->t.getId().equals(id));
        return true;
    }


}
