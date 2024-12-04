import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LinkRoutingModule } from './link-routing.module';
import { LinkComponent } from './link.component';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { LinkEffects } from './store/link.effects';
import { linkReducer } from './store/link.reducer';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [LinkComponent],
  imports: [
    CommonModule,
    LinkRoutingModule,
    FormsModule,
    StoreModule.forFeature('links', linkReducer),
    EffectsModule.forFeature([LinkEffects]),
  ],
})
export class LinkModule {}
