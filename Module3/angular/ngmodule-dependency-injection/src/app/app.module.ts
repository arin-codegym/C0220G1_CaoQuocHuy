import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ImageGalleryModule} from './image-gallery/image-gallery.module';
import {GalleryConfig} from './image-gallery/token';
import {ImageSliderModule} from './image-slider/image-slider.module';
import {ContentProjectionModule} from "./content-projection/content-projection.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    // AppRoutingModule,
    ImageGalleryModule,
    ImageSliderModule,
    ContentProjectionModule
  ],
  providers: [
    {
      provide: 'some-token',
      useFactory() {
        return Math.random();
      }
    },
    {provide: GalleryConfig, useValue: 2}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
