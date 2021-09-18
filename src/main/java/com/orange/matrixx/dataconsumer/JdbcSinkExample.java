package com.orange.matrixx.dataconsumer;

import java.util.Properties;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.connector.jdbc.*;

import com.orange.matrixx.aggregationclasses.DataAggregation;
import com.orange.matrixx.constants.ConfigurationConstants;
import com.orange.matrixx.modeling.EDRModeling;
import com.orange.matrixx.modelingobjects.EDRModel;
import com.orange.matrixx.objects.OEGEvent;
import com.orange.matrixx.utils.ConstantUtilities;

/**
 * Hello world!
 *
 */
public class JdbcSinkExample {

    static class Book {
        public Book(Long id, String title, String authors, Integer year) {
            this.id = id;
            this.title = title;
            this.authors = authors;
            this.year = year;
        }
        final Long id;
        final String title;
        final String authors;
        final Integer year;
    }

    public static void main(String[] args) throws Exception {
    	final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.fromElements(
                new Book(101L, "Stream Processing with Apache Flink", "Fabian Hueske, Vasiliki Kalavri", 2019),
                new Book(102L, "Streaming Systems", "Tyler Akidau, Slava Chernyak, Reuven Lax", 2018),
                new Book(103L, "Designing Data-Intensive Applications", "Martin Kleppmann", 2017),
                new Book(104L, "Kafka: The Definitive Guide", "Gwen Shapira, Neha Narkhede, Todd Palino", 2017)
        ).addSink(
                JdbcSink.sink(
                        "insert into books (id, title, authors, year) values (?, ?, ?, ?)",
                        (statement, book) -> {
                            statement.setLong(1, book.id);
                            statement.setString(2, book.title);
                            statement.setString(3, book.authors);
                            statement.setInt(4, book.year);
                        },
                        JdbcExecutionOptions.builder()
                                .withBatchSize(1000)
                                .withBatchIntervalMs(200)
                                .withMaxRetries(5)
                                .build(),
                        new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
                                .withUrl("jdbc:oracle:thin:@10.115.55.114:1521/tnadb")
                                .withDriverName("oracle.jdbc.driver.OracleDriver")
                                .withUsername("hyper")
                                .withPassword("hyper1")
                                .build()
                ));
                
        env.execute();
    }
}