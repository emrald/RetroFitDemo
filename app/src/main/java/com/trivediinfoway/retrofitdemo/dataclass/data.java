package com.trivediinfoway.retrofitdemo.dataclass;

/**
 * Created by TI A1 on 12-10-2017.
 */
public class data {

    String hotel_booking_type;
    String hotel_id;
    String hotel_name;

    public String getHotel_booking_type() {
        return hotel_booking_type;
    }

    public data(String hotel_booking_type, String hotel_id, String hotel_name) {
        this.hotel_booking_type = hotel_booking_type;
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }
}