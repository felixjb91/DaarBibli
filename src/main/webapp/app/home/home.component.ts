import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

import { LoginModalService } from 'app/core/login/login-modal.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { NgForm } from '@angular/forms';

import { BooksService } from '../services/books.service';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
  account: Account | null = null;
  authSubscription?: Subscription;
  filesName: string[] = [];
  suggestions: string[] = [];
  loading = false;

  pageLength = 100;
  pageIndex = 0;
  pageSize = 10;

  constructor(private accountService: AccountService, private loginModalService: LoginModalService, private booksService: BooksService) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
  }

  login(): void {
    this.loginModalService.open();
  }

  onSubmit(searchBooks: NgForm): void {
    this.loading = true;
    this.filesName = [];
    this.booksService
      .searchBooks(searchBooks.value, this.pageIndex, this.pageSize)
      .pipe()
      .subscribe(data => {
        console.log(data);

        this.filesName = data;
        // this.filesName = data.page;
        // this.pageLength = data.pageLength;

        this.loading = false;
      });
  }

  public handlePage(e: any): void {
    console.log(e);
    this.pageIndex = e.pageIndex;
    // this.pageSize = e.pageSize;
  }
}
