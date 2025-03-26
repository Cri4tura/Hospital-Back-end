package com.hospital.hospital.response;

import java.util.List;

public class Response<T> {
	private String status;
    private int count;
    private List<T> data;
 
    public Response(String status, int count, List<T> data) {
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
 
    public List<T> getData() {
        return data;
    }
}
