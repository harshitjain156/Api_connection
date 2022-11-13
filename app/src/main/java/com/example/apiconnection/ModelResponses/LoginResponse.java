package com.example.apiconnection.ModelResponses;

public class LoginResponse {
    Data data;

    public LoginResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}

//{
//        "first_name": "string",
//        "last_name": "string",
//        "type": "string",
//        "email": "string",
//        "phone": "string",
//        "gender": "string",
//        "email_verified": true,
//        "verified": true,
//        "address": {
//        "id": 0,
//        "name": "string",
//        "phone": "string",
//        "address1": "string",
//        "address2": "string",
//        "city": "string",
//        "state": "string",
//        "pincode": "string",
//        "location": "string",
//        "latitude": 0,
//        "longitude": 0,
//        "default": true
//        },
//        "has_password": true,
//        "retail": {
//        "shop_name": "string",
//        "shop_address": {
//        "id": 0,
//        "name": "string",
//        "phone": "string",
//        "address1": "string",
//        "address2": "string",
//        "city": "string",
//        "state": "string",
//        "pincode": "string",
//        "location": "string",
//        "latitude": 0,
//        "longitude": 0,
//        "default": true
//        }
//        },
//        "form_20": [
//        {
//        "id": 0,
//        "name": "string",
//        "file_name": "string",
//        "file_number": "string",
//        "uploaded_at": "2022-11-05T13:57:43.780Z",
//        "approval_status": true,
//        "remark": "string"
//        }
//        ],
//        "form_21": [
//        {
//        "id": 0,
//        "name": "string",
//        "file_name": "string",
//        "file_number": "string",
//        "uploaded_at": "2022-11-05T13:57:43.781Z",
//        "approval_status": true,
//        "remark": "string"
//        }
//        ],
//        "food_license": [
//        {
//        "id": 0,
//        "name": "string",
//        "file_name": "string",
//        "file_number": "string",
//        "uploaded_at": "2022-11-05T13:57:43.781Z",
//        "approval_status": true,
//        "remark": "string"
//        }
//        ],
//        "gstin": [
//        {
//        "id": 0,
//        "name": "string",
//        "file_name": "string",
//        "file_number": "string",
//        "uploaded_at": "2022-11-05T13:57:43.781Z",
//        "approval_status": true,
//        "remark": "string"
//        }
//        ],
//        "access_token": "string",
//        "refresh_token": "string",
//        "new_user": true
//        }
