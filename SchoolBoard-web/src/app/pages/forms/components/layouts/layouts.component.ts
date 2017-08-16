import {Component} from '@angular/core';
import { NgUploaderModule } from 'ngx-uploader';

@Component({
  selector: 'applayouts',
  templateUrl: './layouts.html',
})
export class Layouts {

  public defaultPicture = 'assets/img/theme/no-photo.png';
  public profile: any = {
    picture: 'assets/img/app/profile/Nasta.png'
  };
  public uploaderOptions: NgUploaderModule = {
    // url: 'http://website.com/upload'
    url: '',
  };

  public fileUploaderOptions: NgUploaderModule = {
    // url: 'http://website.com/upload'
    url: '',
  };

  constructor() {
  }

  ngOnInit() {
  }
}
