import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomLinkRoutingModule } from './custom-link-routing.module';
import { CustomLinkComponent } from './custom-link.component';
import { StoreModule } from '@ngrx/store';
import { customLinkReducer } from './store/custom-link.reducer';
import { FormsModule } from '@angular/forms';
import { LinkRowBoxComponent } from '../../libary/compoments/link-row-box/link-row-box.component';
import { EffectsModule } from '@ngrx/effects';
import { CustomLinkEffects } from './store/custom-link.effects';

@NgModule({
  declarations: [CustomLinkComponent],
  imports: [
    CommonModule,
    CustomLinkRoutingModule,
    FormsModule,
    LinkRowBoxComponent,
    StoreModule.forFeature('custom-link', customLinkReducer),
    EffectsModule.forFeature([CustomLinkEffects]),
  ],
})
export class CustomLinkModule {}
