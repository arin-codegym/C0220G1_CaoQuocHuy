import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageSliderComponent } from './image-slider.component';
import { ImgSlideComponent } from './img-slide/img-slide.component';



@NgModule({
  declarations: [ImageSliderComponent, ImgSlideComponent],
  imports: [
    CommonModule
  ],
  exports: [ImageSliderComponent, ImgSlideComponent]
})
export class ImageSliderModule { }
