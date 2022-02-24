package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//                            new Topic("java", "Java topic", "java desc"),
//                            new Topic("python", "python topic", "python desc"),
//                            new Topic("javascript", "javascript topic", "javascript desc")
//                          ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }


    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);

    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
        return;
    }
}
