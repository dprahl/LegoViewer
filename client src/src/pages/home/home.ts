import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { SearchPage } from '../search/search';
import { ListPage } from '../list/list';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {}

  goToSearch() {
    this.navCtrl.push(SearchPage);
  }

  goToList() {
    this.navCtrl.push(ListPage);
  }

}
