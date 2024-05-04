package com.bilgeadam.repository;

import com.bilgeadam.entity.Barrow;
import com.bilgeadam.entity.Book;

public class BarrowRepository extends Repository<Barrow,Long >{

    public BarrowRepository() {
        super(new Barrow());
    }
}
