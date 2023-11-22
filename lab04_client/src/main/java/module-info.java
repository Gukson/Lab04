module io.github.gukson.lab04.client{
    requires com.google.gson;
    requires javax.annotation.api;
    requires java.sql;
    requires org.apache.commons.lang3;
    requires org.apache.logging.log4j;
    opens io.github.gukson.lab04.client.model to com.google.gson;
    opens io.github.gukson.lab04.client.service to com.google.gson;
    exports io.github.gukson.lab04.client;
    exports io.github.gukson.lab04.client.dao;
    exports io.github.gukson.lab04.client.model;
}