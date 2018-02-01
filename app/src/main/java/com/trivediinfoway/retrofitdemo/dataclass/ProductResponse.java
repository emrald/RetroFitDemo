package com.trivediinfoway.retrofitdemo.dataclass;

import com.trivediinfoway.retrofitdemo.dataclass.data;

import java.util.List;

/**
 * Created by TI A1 on 12-10-2017.
 */
public class ProductResponse {

    boolean error;
    String message;
    String total;
    String hotel_name;
  /*  @SerializedName("data")
    @Expose*/
    List<com.trivediinfoway.retrofitdemo.dataclass.data> data = null;

    public String getHotel_name() {
        return hotel_name;
    }

    public List<data> getData() {
        return data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
