import axios from "axios";
// export const baseURL = "http://140.245.249.186";
// export const baseURL = "http://localhost:8080";
export const baseURL = "https://api.koustavmanna.tech";

export const httpClient = axios.create({
  baseURL: baseURL,
});
