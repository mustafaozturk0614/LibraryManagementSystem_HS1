package com.bilgeadam.service;

import com.bilgeadam.entity.Borrow;
import com.bilgeadam.repository.BorrowRepository;

import java.util.List;
import java.util.Optional;

public class BorrowService {


    private BorrowRepository borrowRepository;

    public BorrowService() {
        this.borrowRepository = new BorrowRepository();
    }


    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }



    public void saveReturnDate(Borrow borrow) {
        borrow.setReturnDate(borrow.getBorrowDate().plusDays(borrow.getPeriod()));
    }
}
