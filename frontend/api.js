//import axios from "axios";
//
//const API = axios.create({
//  baseURL: "http://localhost:8080/notifications",
//});
//
//// 🔐 Add JWT token here
//API.interceptors.request.use((req) => {
//  const token = localStorage.getItem("token");
//  if (token) {
//    req.headers.Authorization = `Bearer ${token}`;
//  }
//  return req;
//});
//
//// ✅ Send notification
//export const sendNotification = (data) =>
//  API.post("/send", data);
//
//// ✅ Get all notifications
//export const getMyNotifications = () =>
//  API.get("/my");
//
//// ✅ Get unread
//export const getUnread = () =>
//  API.get("/unread");
//
//// ✅ Mark as read
//export const markAsRead = (id) =>
//  API.put(`/read/${id}`);