import { isCreateWeatherDataPayload } from "./isCreateWeatherDataPayload";

export interface Product {
  star_rating?: string;
  price: string;
  title: string;
  image_key: string;
}

export const isProduct = (t: object): t is Product => {
  return "price" in t && "title" in t && "image_key" in t;
};

export const isProductArray = (t: object[]): t is Product[] => {
  return t.find((product) => !isProduct(product)) === undefined;
};

export type CreateListPayload = Omit<List, "id">;

export interface List {
  id: string;
  created_at: number;
  from: string;
  message_for_santa: string;
  behaviour_score: number;
  product_names: Product[];
}

export interface WeatherData {
  id: string;
  date: Date;
  temperature: number;
  pressure: number;
  humidity: number;
}

export type CreateWeatherDataPayload = Omit<WeatherData, "id">;

export const isWeatherData = (t: object): t is WeatherData => {
  return "temperature" in t && "pressure" in t && "humidity" in t;
};

export const isWeatherDataArray = (t: object[]): t is WeatherData[] => {
  return t.find((WeatherData) => !isWeatherData(WeatherData)) === undefined;
};
