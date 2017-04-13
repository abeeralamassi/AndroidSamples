/*
Navicat SQLite Data Transfer

Source Server         : 062
Source Server Version : 31300
Source Host           : :0

Target Server Type    : SQLite
Target Server Version : 31300
File Encoding         : 65001

Date: 2017-04-13 10:07:13
*/

PRAGMA foreign_keys = OFF;

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS "main"."contacts";
CREATE TABLE "contacts" (
"id"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"name"  TEXT NOT NULL,
"phone_number"  TEXT,
"email_address"  TEXT
);
PRAGMA foreign_keys = ON;
