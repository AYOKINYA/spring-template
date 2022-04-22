#!/bin/bash
set -e

mongo <<EOF
use $MONGO_INITDB_DATABASE
db.createCollection("layout_users")
db.layout_users.insert({
    "username": "second",
    "layouts": [
        {
            "layoutId": "62383b012e6384083c89ba0d",
            "layoutName": "Operate",
            "isVideoOn": true,
            "items": [
                {
                    "i": "0",
                    "x": 9,
                    "y": 0,
                    "w": 3,
                    "h": 4,
                    "minW": 2,
                    "minH": 3,
                    "static": false
                },
                {
                    "i": "2",
                    "x": 9,
                    "y": 12,
                    "w": 3,
                    "h": 12,
                    "minW": 3,
                    "minH": 3,
                    "static": false
                }
            ]
        },
        {
            "layoutId": "623c26e83a777502ce2ad9cb",
            "layoutName": "test",
            "isVideoOn": false,
            "items": []
        }
    ]
})
EOF