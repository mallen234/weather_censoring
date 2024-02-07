import { WeatherData, CreateWeatherDataPayload } from "./types";

export function isCreateWeatherDataPayload(
  obj: any
): obj is CreateWeatherDataPayload {
  return (
    typeof obj === "object" &&
    obj !== null &&
    typeof obj.temperature === "number" &&
    typeof obj.pressure === "number" &&
    typeof obj.humidity === "number"
  );
  //   return true;
}
