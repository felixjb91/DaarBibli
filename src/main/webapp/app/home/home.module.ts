import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DaarBibliSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatButtonModule } from '@angular/material/button';
import { TextFieldModule } from '@angular/cdk/text-field';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatInputModule } from '@angular/material/input';

@NgModule({
  imports: [
    DaarBibliSharedModule,
    RouterModule.forChild([HOME_ROUTE]),
    MatFormFieldModule,
    MatSelectModule,
    MatSliderModule,
    MatButtonModule,
    TextFieldModule,
    MatSlideToggleModule,
    MatInputModule
  ],
  declarations: [HomeComponent]
})
export class DaarBibliHomeModule {}
