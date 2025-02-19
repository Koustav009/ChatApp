import axios from "axios";
export const baseURL = "http://140.245.249.186";
export const httpClient = axios.create({
  baseURL: baseURL,
});
