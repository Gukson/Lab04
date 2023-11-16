module io.github.gukson.lab04.client{
    requires com.google.gson;
    requires javax.annotation.api;
    requires java.sql;
    opens io.github.gukson.lab04.client.model to com.google.gson;
    //TODO przeczytać provides and export https://github.com/eugenp/tutorials/blob/master/maven-modules/multimodulemavenproject/maven-userdaomodule/src/main/java/module-info.java
    //TODO zależności maven
    //TODO apachicommons
    //TODO guava
}