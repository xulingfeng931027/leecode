package mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/11/5
 */
public class Producer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        producer.setNamesrvAddr("114.215.147.110:9876");
//   producer.setVipChannelEnabled(false);
        try {
            producer.start();
//            producer.createTopic("1", "PushTopic", 1);
            Message message = new Message("PushTopic", "push", "1", "我是逼哥".getBytes());
            SendResult result = producer.send(message);
            System.out.println("id:" + result .getMsgId() +
                    " result:" + result.getSendStatus());
            message = new Message("PushTopic",
                    "push",
                    "2",
                    "Just for test.".getBytes());

            result = producer.send(message);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            message = new Message("PushTopic",
                    "push",
                    "1",
                    "Just for test.".getBytes());

            result = producer.send(message);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }
}
