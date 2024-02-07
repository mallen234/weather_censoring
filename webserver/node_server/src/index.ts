import express, { Request, Response } from "express";
import database from "./database";
import { CreateWeatherDataPayload } from "./types";
import { isCreateWeatherDataPayload } from "./isCreateWeatherDataPayload";

const PORT = 8080;

const app = express();
app.use(express.json());

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

app.listen(PORT, () => {
  console.log(
    `API server listening on port ${PORT} - http://localhost:${PORT}`
  );
});
