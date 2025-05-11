const express = require("express");
const app = express();

const PORT = 3000;
const HOSTNAME = "127.0.0.1";

app.use(express.static(__dirname));

app.get("/", function (req, res) {
   res.sendFile(path.join(__dirname, "index.html"));
});
app.get("/settings", function (req, res) {
   res.sendFile(path.join(__dirname, "settings.html"));
});
app.get("/settings", function (req, res) {
   res.sendFile(path.join(__dirname, "about.html"));
});

app.listen(PORT, HOSTNAME, () => {
   console.log(`Server listening at http://${HOSTNAME}:${PORT}`);
});
