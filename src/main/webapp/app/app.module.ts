import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { DaarBibliSharedModule } from 'app/shared/shared.module';
import { DaarBibliCoreModule } from 'app/core/core.module';
import { DaarBibliAppRoutingModule } from './app-routing.module';
import { DaarBibliHomeModule } from './home/home.module';
import { DaarBibliEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  imports: [
    BrowserModule,
    DaarBibliSharedModule,
    DaarBibliCoreModule,
    DaarBibliHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    DaarBibliEntityModule,
    DaarBibliAppRoutingModule,
    BrowserAnimationsModule
    // ------Angular Material--------
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class DaarBibliAppModule {}
