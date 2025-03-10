package entity;

import java.util.List;

public class RoomResponse {
	private String status;
    private int count;
    private List<Room> data;
 
    public RoomResponse(String status, int count, List<Room> data) {
        this.status = status;
        this.count = count;
        this.data = data;
    }
 
    public String getStatus() {
        return status;
    }
 
    public int getCount() {
        return count;
    }
 
    public List<Room> getData() {
        return data;
    }
}
