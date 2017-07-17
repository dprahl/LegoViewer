import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { ResultsPage } from '../results/results';

@Component({
  selector: 'page-search',
  templateUrl: 'search.html'
})
export class SearchPage {

      constructor(public navCtrl: NavController, public navParams: NavParams) {}

      goToSearchSetNumber(value1){
        this.navCtrl.push(ResultsPage, {searchCriteriaSetNumber: value1});
      }

      goToSearchDescription(value2){
        this.navCtrl.push(ResultsPage, {searchCriteriaDescription: value2});
      }

}
