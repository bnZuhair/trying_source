const http = require("http");
const fs = require("fs");
const PORT = 3000;
const HOSTNAME = "127.0.0.1";

const server = http.createServer(requestHandler(req, res));

server.listen(
   PORT,
   HOSTNAME,
   () => console.log(`Server running at http://${HOSTNAME}:${PORT}/`),
);
