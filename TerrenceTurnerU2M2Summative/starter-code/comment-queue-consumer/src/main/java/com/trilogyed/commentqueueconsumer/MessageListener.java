package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.util.feign.CommentClient;
import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentClient client;

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment comment) {
        if (comment.getCommentId() == 0) {
            client.createComment(comment);
        } else {
            client.updateComment(comment.getCommentId(), comment);
        }
    }
}
