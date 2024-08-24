const express = require("express");
const cors = require("cors");

// Rotas
const index = require("./routes/index");
const userRoute = require("./routes/user");
const productRoute = require("./routes/product");

const app = express();

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(express.json({ type: "application/vnd.api+json" }));
app.use(cors());

app.use(index);
app.use("/api/", userRoute);
app.use("/api/", productRoute);

module.exports = app;
