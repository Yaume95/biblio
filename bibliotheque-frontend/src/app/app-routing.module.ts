import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReaderListPageComponent } from 'src/app/reader-list/reader-list-page/reader-list-page.component';

const routes: Routes = [
  { path: ':user/books', component: ReaderListPageComponent, title: 'Liste de Julie'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
