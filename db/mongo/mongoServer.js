const express = require('express');
const { MongoClient } = require('mongodb')
const app = express();

const connectionString =
   process.env.MONGODB_CONNECTION_STRING || "mongodb://localhost:27017";

let db;

MongoClient.connect(connectionString)
   .then(client => {
      console.log('Connected to MongoDB');
      db = client.db('trying');
   })
   .catch(err => {
      console.error('Failed to connect to MongoDB', err);
      process.exit(1);
   });


app.get("/", (req, res) => {
   res.sendFile(__dirname + "/static/index.html");
});
app.get("/get", async (req, res) => {
   const searchText = req.query.search;

   const pets = await db.collection("pets").find(
      {
         $text: { $search: searchText },
      },
      { projection: { _id: 0, index: false } },
   ).limit(10)
      .toArray();

   res.json({ status: "ok", pets }).end();
});


const PORT = 8000
app.listen(PORT, () => {
   console.log(`Server listening at http://localhost:${PORT}`);
});
