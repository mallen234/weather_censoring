import fs from "fs";
import {
  CreateListPayload,
  isWeatherData,
  WeatherData,
  isWeatherDataArray,
  List,
  CreateWeatherDataPayload,
} from "./types";
import { v4 as generateUUID } from "uuid";

class Database {
  data: WeatherData[];
  constructor() {
    let rawWeFiles;
    try {
      rawWeFiles = JSON.parse(
        fs.readFileSync("data/weatherData.json", "utf-8")
      );
    } catch {
      throw new Error("Unable to parse data data file");
    }
    if (!isWeatherDataArray(rawWeFiles)) {
      throw new Error("Format issue with data data file");
    }

    this.data = rawWeFiles;
  }

  public getdata(): WeatherData[] {
    return this.data;
  }

  public searchData(query: string): WeatherData[] {
    // TODO: Consider how we might use this function...
    return this.data;
  }

  public addData(newWeatherData: CreateWeatherDataPayload) {
    const dataWithId = {
      ...newWeatherData,
      id: generateUUID(),
      date: new Date(),
    };

    this.data.push(dataWithId);
    this.writeDataToFile();
    return dataWithId;
  }

  private writeDataToFile() {
    fs.writeFileSync("data/weatherData.json", JSON.stringify(this.data));
  }
}

const db = new Database();
export default db;
