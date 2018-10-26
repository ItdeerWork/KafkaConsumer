package cn.itdeer.mode1;

import cn.itdeer.utils.Constants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Arrays;
import java.util.Properties;

/**
 * Directions:
 * PackageName: cn.itdeer.mode1.
 * ProjectName: KafkaConsumer.
 * Creator: itdeer.
 * CreationTime: 2018/10/24 16:39.
 */

public class Consumer extends Thread{

    private final KafkaConsumer<String,String> consumer;

    public Consumer() {
        Properties properties = new Properties();
        properties.put(Constants.BOOTSTRAP_SERVERS,Constants.BOOTSTRAP_SERVERS_VALUE);
        properties.put(Constants.GROUP_ID_CONFIG,Constants.GROUP_ID_CONFIG_VALUE + "123456");
        properties.put(Constants.KEY_DESERIALIZER_CLASS,Constants.KEY_DESERIALIZER_CLASS_STRING);
        properties.put(Constants.VALUE_DESERIALIZER_CLASS,Constants.VALUE_DESERIALIZER_CLASS_STRING);
        properties.put(Constants.AUTO_COMMIT_INTERVAL_MS_CONFIG,Constants.AUTO_COMMIT_INTERVAL_MS_CONFIG_VALUE);
        properties.put(Constants.MAX_POLL_RECORDS_CONFIG,Constants.MAX_POLL_RECORDS_CONFIG_VALUE);
        properties.put(Constants.FETCH_MAX_BYTES_CONFIG,Constants.FETCH_MAX_BYTES_CONFIG_VALUE);
        properties.put(Constants.FETCH_MAX_WAIT_MS_CONFIG,Constants.FETCH_MAX_WAIT_MS_CONFIG_VALUE);
        properties.put(Constants.SESSION_TIMEOUT_MS_CONFIG,Constants.SESSION_TIMEOUT_MS_CONFIG_VALUE);
        properties.put(Constants.HEARTBEAT_INTERVAL_MS_CONFIG,Constants.HEARTBEAT_INTERVAL_MS_CONFIG_VALUE);
        properties.put(Constants.MAX_POLL_INTERVAL_MS_CONFIG,Constants.MAX_POLL_INTERVAL_MS_CONFIG_VALUE);
        properties.put(Constants.AUTO_OFFSET_RESET_CONFIG,Constants.AUTO_OFFSET_RESET_CONFIG_VALUE);
        properties.put(Constants.ENABLE_AUTO_COMMIT_CONFIG,Constants.ENABLE_AUTO_COMMIT_CONFIG_VALUE);

        consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList(Constants.TOPIC_NAME));
    }

    @Override
    public void run() {
        int totle_num = 100;
        int num = 0;
        long startTime = System.currentTimeMillis();
        while (num < totle_num){
            ConsumerRecords<String,String> records = consumer.poll(100);
            for (ConsumerRecord record: records) {
                num ++;
            }
        }
        long endTime = System.currentTimeMillis();
        double totle_time = (double)(endTime-startTime)/1000;
        System.out.println("共消费：" + totle_num + "条 共用时：" +  totle_time + "秒 速率" + totle_num/totle_time);
    }

}
