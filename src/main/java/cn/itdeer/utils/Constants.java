package cn.itdeer.utils;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.text.SimpleDateFormat;

/**
 * Directions: 常量工具类
 * PackageName: cn.itdeer.utils.
 * ProjectName: KafkaConsumer.
 * Creator: itdeer.
 * CreationTime: 2018/10/24 16:38.
 */

public class Constants {

    /**
     * 参数默认值
     */

    public static Integer THREAD_NUMS = 1;
    public static String TOPIC_NAME = "sundafei";


    public static Integer LOOP_NUMS = 100;
    public static Integer LOOP_DATA_NUMS = 10000;
    public static Integer MESSAGE_SIZE_NUMS = 100;

    public static Integer PARTITION_NUMS = 3;
    public static Integer REPLICATION_NUMS = 1;


    /**
     * 时间格式
     */
    public static final String DATA_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat format = new SimpleDateFormat(DATA_FORMAT);

    public static final String GROUP_ID_CONFIG = ConsumerConfig.GROUP_ID_CONFIG;
    public static final String GROUP_ID_CONFIG_VALUE = TOPIC_NAME + "_group";

    /**
     * bootstrap.servers:用于初始化时建立链接到kafka集群,
     * 以host:port形式,多个以逗号分隔host1:port1,host2:port2
     * znhcy-edcjrd-01.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-02.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-03.edcadpd.zhenergy.com.cn:6667
     * 10.154.96.72:6667,10.154.96.73:6667,10.154.96.74:6667
     */
    public static final String BOOTSTRAP_SERVERS = ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
    public static final String BOOTSTRAP_SERVERS_VALUE = "znhcy-edcjrd-01.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-02.edcadpd.zhenergy.com.cn:6667,znhcy-edcjrd-03.edcadpd.zhenergy.com.cn:6667";

    /**
     * key.serialization, value.serialization说明了使用何种序列化方式将用户提供的key和vaule值反序列化成字符
     */
    public static final String KEY_DESERIALIZER_CLASS = ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
    public static final String KEY_DESERIALIZER_CLASS_STRING = "org.apache.kafka.common.serialization.StringDeserializer";
    public static final String VALUE_DESERIALIZER_CLASS = ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
    public static final String VALUE_DESERIALIZER_CLASS_STRING = "org.apache.kafka.common.serialization.StringDeserializer";

    public static final String AUTO_COMMIT_INTERVAL_MS_CONFIG = ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG;
    public static final Integer AUTO_COMMIT_INTERVAL_MS_CONFIG_VALUE = 1000;

    public static final String MAX_POLL_RECORDS_CONFIG = ConsumerConfig.MAX_POLL_RECORDS_CONFIG;
    public static final Integer MAX_POLL_RECORDS_CONFIG_VALUE = 20000;

    public static final String FETCH_MAX_BYTES_CONFIG = ConsumerConfig.FETCH_MAX_BYTES_CONFIG;
    public static final Integer FETCH_MAX_BYTES_CONFIG_VALUE = 1024 * 1024 * 10;

    public static final String FETCH_MAX_WAIT_MS_CONFIG = ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG;
    public static final Integer FETCH_MAX_WAIT_MS_CONFIG_VALUE = 1000;

    public static final String SESSION_TIMEOUT_MS_CONFIG = ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG;
    public static final Integer SESSION_TIMEOUT_MS_CONFIG_VALUE = 10000;

    public static final String HEARTBEAT_INTERVAL_MS_CONFIG = ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG;
    public static final Integer HEARTBEAT_INTERVAL_MS_CONFIG_VALUE = 1000;

    public static final String MAX_POLL_INTERVAL_MS_CONFIG = ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG;
    public static final Integer MAX_POLL_INTERVAL_MS_CONFIG_VALUE = 1000 * 60;

    public static final String AUTO_OFFSET_RESET_CONFIG = ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
    public static final String AUTO_OFFSET_RESET_CONFIG_VALUE = "earliest";

    public static final String ENABLE_AUTO_COMMIT_CONFIG = ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG;
    public static final String ENABLE_AUTO_COMMIT_CONFIG_VALUE = "true";
}

