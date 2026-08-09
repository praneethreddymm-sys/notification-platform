import React, { useEffect, useState } from "react";
import {
  sendNotification,
  getMyNotifications,
  getUnread,
  markAsRead,
} from "./api";
import "./styles.css";

function NotificationPage() {
  const [notifications, setNotifications] = useState([]);
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  // ✅ Load all notifications
  const loadNotifications = async () => {
    const res = await getMyNotifications();
    setNotifications(res.data);
  };

  // ✅ Send notification
  const handleSend = async () => {
    if (!email || !message) {
      alert("Enter email & message");
      return;
    }

    await sendNotification({ email, message });
    setEmail("");
    setMessage("");
    loadNotifications();
  };

  // ✅ Mark as read
  const handleRead = async (id) => {
    await markAsRead(id);
    loadNotifications();
  };

  // ✅ Load on page load
  useEffect(() => {
    loadNotifications();
  }, []);

  return (
    <div className="container">
      <h2>📩 Notification System</h2>

      {/* Send Notification */}
      <div className="form">
        <input
          type="email"
          placeholder="Enter email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="text"
          placeholder="Enter message"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />

        <button onClick={handleSend}>Send</button>
      </div>

      {/* Notification List */}
      <h3>Your Notifications</h3>

      {notifications.map((n) => (
        <div
          key={n.id}
          className={n.isRead ? "card read" : "card unread"}
        >
          <p><strong>{n.message}</strong></p>
          <p>{n.email}</p>

          {!n.isRead && (
            <button onClick={() => handleRead(n.id)}>
              Mark as Read
            </button>
          )}
        </div>
      ))}
    </div>
  );
}

export default NotificationPage;