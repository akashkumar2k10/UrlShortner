import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { AuthGuard } from '../auth/store/auth.guard';

const routes: Routes = [

  {
    path:'',
    component:HomeComponent,
    canActivate:[AuthGuard],
    children:[
      {
        path:'dashborad',
        loadChildren:()=> import('./dashboard/dashboard.module').then(m=>m.DashboardModule),
      },
      {
        path:'custom-link',
        loadChildren:()=> import('./custom-link/custom-link.module').then(m=>m.CustomLinkModule),
      },
      {
        path:'link',
        loadChildren:()=> import('./link/link.module').then(m=>m.LinkModule),
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
