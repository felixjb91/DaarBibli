import { Component, Input, OnInit } from '@angular/core';
import { BASE_URL_BOOKS, NO_IMAGE } from 'app/app.constants';
import { BooksService } from 'app/services/books.service';
@Component({
  selector: 'jhi-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  @Input()
  filename = '';
  subFilename = '';
  imageSrc = '';
  suggestions: string[] = [];
  private displaySuggestion = false;

  constructor(private booksService: BooksService) {}

  ngOnInit(): void {
    this.subFilename = this.filename.substring(0, this.filename.length - 4);
    this.imageSrc = 'https://www.gutenberg.org/cache/epub/' + this.subFilename + '/pg' + this.subFilename + '.cover.medium.jpg';
  }

  updateUrl(): void {
    this.imageSrc = NO_IMAGE;
  }

  private getSuggestion(): void {
    this.displaySuggestion = !this.displaySuggestion;
    if (this.suggestions.length === 0)
      this.booksService
        .searchSuggestion(this.filename)
        .pipe()
        .subscribe(name => (this.suggestions = name));
  }

  generateURL(): string {
    return BASE_URL_BOOKS + this.filename.split('.')[0];
  }
}
