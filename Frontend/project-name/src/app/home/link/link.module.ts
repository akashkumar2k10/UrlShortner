import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LinkRoutingModule } from './link-routing.module';
import { LinkComponent } from './link.component';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { LinkEffects } from './store/link.effects';
import { linkReducer } from './store/link.reducer';
import { FormsModule } from '@angular/forms';
import { LinkRowBoxComponent } from '../../libary/compoments/link-row-box/link-row-box.component';

@NgModule({
  declarations: [LinkComponent],
  imports: [
    CommonModule,
    LinkRoutingModule,
    FormsModule,
    LinkRowBoxComponent,
    StoreModule.forFeature('links', linkReducer),
    EffectsModule.forFeature([LinkEffects]),
  ],
})
export class LinkModule {}
