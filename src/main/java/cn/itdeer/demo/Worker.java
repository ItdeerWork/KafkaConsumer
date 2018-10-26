package cn.itdeer.demo;


import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Worker implements Runnable {
    private ConsumerRecord<String, String> consumerRecord;
    private int num;


    public Worker(ConsumerRecord record,int num) {
        this.consumerRecord = record;
        this.num = num;
    }

    public void run() {
        System.out.println("条数：" + num + "   " + Thread.currentThread().getName() + " consumed " + consumerRecord.partition() + "th message with offset: " + consumerRecord.offset());
    }

    /*@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " consumed " + consumerRecord.partition() + "th message with offset: " + consumerRecord.offset());
    }*/
}
