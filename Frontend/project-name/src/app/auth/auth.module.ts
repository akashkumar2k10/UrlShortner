import { ModuleWithProviders, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { AuthComponent } from './auth.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SuccessComponent } from './success/success.component';


@NgModule({
  declarations: [
    AuthComponent,
    SuccessComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  bootstrap:[AuthComponent]
})
export class AuthModule { 
  static forRoot() : ModuleWithProviders<AuthModule>{
    return {
      ngModule : AuthModule,
    }
  }
}
