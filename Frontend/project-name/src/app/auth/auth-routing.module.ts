import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth.component';
import { SuccessComponent } from './success/success.component';
import { AppComponent } from '../app.component';

const routes: Routes = [
  {
    path: '',
    component: AuthComponent,
  },
  { path: 'success', component: SuccessComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
