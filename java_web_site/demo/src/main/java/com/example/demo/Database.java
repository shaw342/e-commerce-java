package com.example.demo;
import com.mongodb.*;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import io.micrometer.observation.transport.Propagator.Setter;

public class Database {
      public static MongoClientSettings connectDatabase(){
        
        String url = System.getenv("MON_API_KEY");
        ServerApi serverApi = ServerApi.builder()
        .version(ServerApiVersion.V1)
        .build();
        MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(url))
        .serverApi(serverApi).build();

        return settings;
     }

     public static void addCustomers(User data){
        
        Document newData = new Document();
        newData.append("name", data.getName());
        newData.append("email",data.getEmail());
        newData.append("password", data.getPassword());

        MongoClientSettings settings = connectDatabase();
        System.out.println(data);
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("e-commerce-data");
            try {
                //Document commandResult = database.runCommand(command);
                database.getCollection("Customers").insertOne(newData);
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException me) {
                System.err.println(me);
            }
        }
     }
     public static void createCredentials(User data){
        Document newData = new Document();
        MongoClientSettings settings = connectDatabase();
       try (MongoClient mongoClient = MongoClients.create(settings)){
        MongoDatabase database = mongoClient.getDatabase("e-commerce-data");
        try {
            MongoCredential credential = MongoCredential.createCredential(data.getName(),"e-commerce-data", data.getPassword());
            System.out.println("##########\n"+ credential.getMechanism()+"##########\n");
        } catch (Exception e) {
            // TODO: handle exception
            
        }
       } catch (Exception e) {
        // TODO: handle exception
       }

     }

}
