package com.bilgeadam.repository;

import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;

public class UserInformationRepository extends Repository<UserInformation,Long >{

    public UserInformationRepository() {
        super(new UserInformation());
    }
}
