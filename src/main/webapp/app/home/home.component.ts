import { Component, OnInit, OnDestroy } from '@angular/core';
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
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;
  filesName: string[] = [];
  suggestions: string[] = [];
  loading = false;

  constructor(private accountService: AccountService, private loginModalService: LoginModalService, private booksService: BooksService) {}

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState().subscribe(account => (this.account = account));
  }

  login(): void {
    this.loginModalService.open();
  }

  ngOnDestroy(): void {
    if (this.authSubscription) this.authSubscription.unsubscribe();
  }

  onSubmit(searchBooks: NgForm): void {
    this.loading = true;
    this.booksService
      .searchBooks(searchBooks.value)
      .pipe()
      .subscribe(name => {
        this.filesName = name;
        this.loading = false;
      });
  }
}
