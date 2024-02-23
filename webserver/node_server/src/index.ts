import express, { Request, Response, NextFunction } from "express";
import database from "./database";
import { CreateWeatherDataPayload } from "./types";
import { isCreateWeatherDataPayload } from "./isCreateWeatherDataPayload";

import dotenv from "dotenv";

dotenv.config();

const LAN: string = process.env.LAN || "";
const PORT = parseInt(process.env.PORT || "kk");

export interface TokenRequest extends Request {
  originalPath?: string;
}

console.log(LAN, PORT);
// const PORT = 8080;
const app = express();
app.use(express.json());

app.use((req: TokenRequest, res, next) => {
  // Get the original path from the headers
  // req.originalPath = req.headers["x-original-uri"] || req.url;

  console.log("Original Path:", req.headers["x-original-uri"]);
  if (typeof req.headers["x-original-uri"] === "string") {
    req.originalPath = req.headers["x-original-uri"];
  }
  next();
});

app.get("/", (req: TokenRequest, res: Response) => {
  if (!!req.originalPath) {
    res.redirect(req.originalPath);
  } else {
    console.log(req);
    res.status(400).send();
  }
});

app.get("/health", (req: Request, res: Response) => {
  res.send("OK");
});

// app.get("/lists", (req: Request, res: Response) => {
//   res.status(200).json(database.getLists());
// });

app.get("/weather", (req: Request, res: Response) => {
  const { body } = req;
  console.log("made it to data");

  const newWeatherDataStatus = database.getdata();
  res.status(201).json(newWeatherDataStatus);
});

app.post("/weather", (req: Request, res: Response) => {
  const { body } = req;
  console.log("made it to data");

  const newWeatherData: CreateWeatherDataPayload = body;
  console.log(newWeatherData);
  if (!isCreateWeatherDataPayload(newWeatherData)) {
    res.status(400).json({ error: "Invalid payload" });
    return;
  }
  const newWeatherDataStatus = database.addData(body);
  res.status(201).json(newWeatherDataStatus);
});

app.listen(PORT, LAN, () => {
  console.log(
    `${LAN} : API server listening on port ${PORT} - http://localhost:${PORT}`
  );
});
