import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //create the client for connection
        MongoClient client = MongoClients.create("mongodb+srv://goktugoner:goktugoner123@cluster0.h0zwq.mongodb.net/?retryWrites=true&w=majority");

        //access to bioData database
        MongoDatabase db = client.getDatabase("BioData");
        MongoCollection<Document> col = db.getCollection("bios");
        System.out.println(col.countDocuments());

        //insert a document to the collection
        Document sampleDoc = new Document("_id", "1").append("name", "goktug oner");
        //col.insertOne(sampleDoc);
        //col.deleteOne(sampleDoc);

        //get the list of databases
        MongoIterable<String> list = client.listDatabaseNames();
        for(String dbName: list){
            System.out.println(dbName);
        }

        //create new database and add collection, then add variables
        MongoDatabase db2 = client.getDatabase("myPals");
        MongoCollection<Document> col2 = db2.getCollection("palData");
        Document sample1 = new Document("_id", "1").append("Name", "Göktuğ").append("Surname", "Öner").append("Date of Birth", "23.08.1989");
        Document sample2 = new Document("_id", "2").append("Name", "Hande Sıla").append("Surname", "Ergezer").append("Date of Birth", "03.09.1997");
        List<Document> documents = new ArrayList<>();
        documents.add(sample1);
        documents.add(sample2);
        col2.insertMany(documents);
    }

}
