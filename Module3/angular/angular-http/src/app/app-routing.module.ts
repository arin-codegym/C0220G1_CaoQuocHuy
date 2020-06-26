import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BlogComponent} from './blog/blog.component';
import {BlogDetailComponent} from './blog-detail/blog-detail.component';
import {BlogEditComponent} from './blog-edit/blog-edit.component';
const routes: Routes = [{
  path: 'blog',
  component: BlogComponent
}, {
  path: 'blog/:id',
  component: BlogDetailComponent
}, {
  path: 'blog/:id/edit',
  component: BlogEditComponent
}];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
 // exports: [RouterModule]
})
export class AppRoutingModule { }
