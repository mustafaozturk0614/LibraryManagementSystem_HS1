package com.bilgeadam.controller;

import com.bilgeadam.entity.Borrow;

import com.bilgeadam.service.BorrowService;

public class BorrowController {

  private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    public Borrow save(Borrow borrow){
      borrowService.saveReturnDate(borrow);
      return   borrowService.save(borrow);
    }

}
