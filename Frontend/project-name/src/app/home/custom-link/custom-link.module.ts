import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomLinkRoutingModule } from './custom-link-routing.module';
import { CustomLinkComponent } from './custom-link.component';
import { StoreModule } from '@ngrx/store';
import { customLinkReducer } from './store/custom-link.reducer';


@NgModule({
  declarations: [
    CustomLinkComponent
  ],
  imports: [
    CommonModule,
    CustomLinkRoutingModule,
    StoreModule.forFeature("custom-link",customLinkReducer)
  ]
})
export class CustomLinkModule { }
