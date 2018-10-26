package cn.itdeer.utils;

import cn.itdeer.utils.Kafka_Consumer;

/**
 * Directions:
 * PackageName: PACKAGE_NAME.
 * ProjectName: KafkaConsumerDemo.
 * Creator: itdeer.
 * CreationTime: 2018/10/23 16:03.
 */
public class Main {

    public static void main(String[] args) {
        Kafka_Consumer kafka_Consumer = new Kafka_Consumer();
        try {
            kafka_Consumer.execute();
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            kafka_Consumer.shutdown();
        }
    }
}
