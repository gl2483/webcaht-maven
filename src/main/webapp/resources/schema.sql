/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  KK
 * Created: May 28, 2016
 */

CREATE SCHEMA webchat

CREATE TABLE USERS
(
    UserId INTeger primary key not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    Username varchar(100) not null,
    Password varchar(256) not null
)


