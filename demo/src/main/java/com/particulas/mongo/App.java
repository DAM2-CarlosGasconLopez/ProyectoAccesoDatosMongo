package com.particulas.mongo;


import java.util.ArrayList;
import java.util.Date;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;




/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Prueba conexión MongoDB");
        String uri = "mongodb+srv://juan:Admin1234@cluster0.dqt0b.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        

        try(MongoClient mongoClient = MongoClients.create(uri)) {
            printDatabases(mongoClient);

             //Si no existe la base de datos la crea
            MongoDatabase db = mongoClient.getDatabase("Disney");
 
         //Crea una tabla si no existe y agrega datos
         MongoCollection table = db.getCollection("Pelicula");

         //Crea los objectos básicos
         Document document1 = new Document();
         document1.put("nombre", "Jose");
         document1.put("apellidos", "Lopez Perez");
         document1.put("anyos", 45);
         document1.put("fecha", new Date());

          //Insertar tablas
          table.insertOne(document1);
        }
  
        

    }

    private static void printDatabases(MongoClient mongo) {
        ArrayList<Object> databases = mongo.listDatabases().into(new ArrayList<Object>());
        for (Object object : databases) {
            System.out.println(object);
        }

    }

    
}