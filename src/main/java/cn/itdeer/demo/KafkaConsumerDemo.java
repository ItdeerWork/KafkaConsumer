package cn.itdeer.demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Directions:
 * PackageName: cn.itdeer.demo.
 * ProjectName: KafkaConsumerDemo.
 * Creator: itdeer.
 * CreationTime: 2018/10/24 9:10.
 */
public class KafkaConsumerDemo extends Thread{

    private final KafkaConsumer<String,String> consumer;

    public KafkaConsumerDemo() {
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"znhcy-edcjrd-01.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-02.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-03.edcadpd.zhenergy.com.cn:6667");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"qwwwsa");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,1000);

        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,20000);

        properties.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG,1024 * 1024 * 10);
        properties.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG,1000);
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,10000);
        properties.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,1000);
        properties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,60 * 1000);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList("sundafei"));
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();
        int num = 0;

        //ExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        while (num < 500000){
            ConsumerRecords<String, String> records = consumer.poll(10);
            for(ConsumerRecord<String,String> record : records){
                num++;
                //executorService.execute(new Worker(record,num));
                //System.out.println(record.value());

            }
        }
        long endTime = System.currentTimeMillis();
        double ti = (endTime-startTime)/1000.0;
        System.out.println("一次共消费：" + num + " 条数据 用时" + ti + "秒" + " 平均：" + num/ti);
    }

    public static void main(String[] args) {

        for (int i=0;i<2;i++){
            Thread thread = new KafkaConsumerDemo();
            thread.start();
        }


       /* KafkaConsumerDemo kcd = new KafkaConsumerDemo();
        kcd.run();*/
    }
}
