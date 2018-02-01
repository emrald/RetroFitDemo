package com.trivediinfoway.retrofitdemo.dataclass;

/**
 * Created by TI A1 on 13-10-2017.
 */
public class UserData {
        String user_id;
        String user_email;
        String user_first_name;
        String user_last_name;
        String user_phone;
        String user_city;
        String state_id;
        String user_state;
        String user_shipping_cost;
        String user_addr1;
        String user_addr2;

        /*public UserData()
        {
            super();
        }*/

        public UserData(String user_id, String user_email, String user_first_name, String user_last_name, String user_phone, String user_city, String state_id, String user_state, String user_shipping_cost, String user_addr1, String user_addr2) {
            this.user_id = user_id;
            this.user_email = user_email;
            this.user_first_name = user_first_name;
            this.user_last_name = user_last_name;
            this.user_phone = user_phone;
            this.user_city = user_city;
            this.state_id = state_id;
            this.user_state = user_state;
            this.user_shipping_cost = user_shipping_cost;
            this.user_addr1 = user_addr1;
            this.user_addr2 = user_addr2;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getUser_email() {
            return user_email;
        }

        public String getUser_first_name() {
            return user_first_name;
        }

        public String getUser_last_name() {
            return user_last_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public String getUser_city() {
            return user_city;
        }

        public String getState_id() {
            return state_id;
        }

        public String getUser_state() {
            return user_state;
        }

        public String getUser_shipping_cost() {
            return user_shipping_cost;
        }

        public String getUser_addr1() {
            return user_addr1;
        }

        public String getUser_addr2() {
            return user_addr2;
        }
    }
