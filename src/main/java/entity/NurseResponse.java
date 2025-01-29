package entity;

import java.util.List;
 
public class NurseResponse {
	private String status;
    private int count;
    private List<Nurse> data;
 
    public NurseResponse(String status, int count, List<Nurse> data) {
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
 
    public List<Nurse> getData() {
        return data;
    }
}