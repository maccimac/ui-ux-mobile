package com.example.bulbdemo;

public class Room {
    String roomName;
    boolean isBulbOne = false;

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isBulbOne() {
        return isBulbOne;
    }

    public void setBulbOne(boolean bulbOne) {
        isBulbOne = bulbOne;
    }
}
