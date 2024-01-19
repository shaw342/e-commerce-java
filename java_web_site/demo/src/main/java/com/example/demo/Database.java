package com.example.demo;
import com.mongodb.*;

import javax.print.Doc;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Database {
     public static MongoClientSettings connectDatabase(){
        String url = "mongodb+srv://shawan:wlOhnb4CT0xNIfoN@cluster0.uv2wfdv.mongodb.net/?retryWrites=true&w=majority";

        ServerApi serverApi = ServerApi.builder()
        .version(ServerApiVersion.V1)
        .build();
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(url))
        .serverApi(serverApi).build();

        return settings;
     }

     public static void addData(User data){
        
        Document newData = new Document();
        newData.append("name", data.getName());
        newData.append("email",data.getEmail());
        newData.append("password", data.getPassword());

        MongoClientSettings settings = connectDatabase();
        System.out.println(data);
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("shawan");
            try {
                //Document commandResult = database.runCommand(command);
                database.getCollection("student").insertOne(newData);
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException me) {
                System.err.println(me);
            }
        }
     }

}
