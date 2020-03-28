import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookComponent, DataSuggestion } from 'app/home/book/book.component';

@Component({
  selector: 'jhi-suggestion',
  templateUrl: './suggestion.component.html',
  styleUrls: ['./suggestion.component.scss']
})
export class SuggestionComponent implements OnInit {
  constructor(public dialogRef: MatDialogRef<BookComponent>, @Inject(MAT_DIALOG_DATA) public dataSuggestion: DataSuggestion) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
  ngOnInit(): void {}
}
