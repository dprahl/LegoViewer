import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { HomePage } from '../home/home';
import { SearchPage } from '../search/search';
import { ListPage } from '../list/list';

@Component({
  selector: 'page-logout',
  templateUrl: 'logout.html'
})
export class LogoutPage {

  constructor(public navCtrl: NavController) {

  }

  goToHome() {
    this.navCtrl.setRoot(HomePage);
    //this.navCtrl.push(HomePage);
  }

}
