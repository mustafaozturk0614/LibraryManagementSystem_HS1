package com.bilgeadam.repository;

import com.bilgeadam.entity.Borrow;

public class BorrowRepository extends Repository<Borrow,Long >{

    public BorrowRepository() {
        super(new Borrow());
    }
}
