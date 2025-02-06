import { httpClient } from "../config/AxiosHelper";

export const createRoomApi = async (roomDetail) => {
  const respone = await httpClient.post(`/rooms/createroom/${roomDetail}`,);
  return respone.data;
};

export const joinChatApi = async (roomId) => {
  const response = await httpClient.get(`/rooms/joinroom/${roomId}`);
  return response.data;
};

export const getMessagess = async (roomId, size = 50, page = 0) => {
  const response = await httpClient.get(
    `/rooms/getmessages/${roomId}?size=${size}&page=${page}`
  );
  return response.data;
};
