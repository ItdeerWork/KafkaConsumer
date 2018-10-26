package cn.itdeer.utils;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Directions:
 * PackageName: cn.itdeer.thread.
 * ProjectName: itdeerlab-tools.
 * Creator: itdeer.
 * CreationTime: 2018/10/22 16:33.
 */
public final class Kafka_Consumer {
    /**
     * kafka消费者不是线程安全的
     */
    private final KafkaConsumer<String, String> consumer;
    private long num =0;

    private long startTime = 0L;
    private long endTime = 0L;


    private ExecutorService executorService;

    public Kafka_Consumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "znhcy-edcjrd-01.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-02.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-03.edcadpd.zhenergy.com.cn:6667");
        props.put("group.id", "5656");
        // 关闭自动提交
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("num.consumer.fetchers",3);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList("sundafei"));
    }

    public void execute() {
        startTime = System.currentTimeMillis();
        executorService = Executors.newFixedThreadPool(3);
        while (num != 400000) {
            ConsumerRecords<String, String> records = consumer.poll(10);
            if (null != records) {
                num ++;
                executorService.submit(new ConsumerThread(records, consumer));
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println("共消费了：" + num + " 时间为：" + (endTime-startTime)/1000);
    }

    public void shutdown() {
        try {
            if (consumer != null) {
                consumer.close();
            }
            if (executorService != null) {
                executorService.shutdown();
            }
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Timeout");
            }
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
