import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { ResultsService } from './resultsService';

@Component({
  selector: 'page-results',
  templateUrl: 'results.html',
  providers:[ResultsService]
})

export class ResultsPage {
  searchCriteriaSetNumber: string;
  searchCriteriaDescription: string;

  selectedItem: any;
  sets: Array<any>=[];

  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public resultsService: ResultsService) {}

  ionViewDidLoad(){
    this.searchCriteriaSetNumber = this.navParams.get('searchCriteriaSetNumber');
    this.searchCriteriaDescription = this.navParams.get('searchCriteriaDescription');

    if(this.searchCriteriaSetNumber != undefined){
      this.resultsService.getSetByNumber(this.searchCriteriaSetNumber)
                      .subscribe(data =>{this.sets = data;})//  console.log(data)})
    } else {
    this.resultsService.getSetByDescription(this.searchCriteriaDescription)
                      .subscribe(data =>{this.sets = data;})//  console.log(data)})
    }

    //console.log(this.navParams.get('searchCriteriaSetNumber'));
    //console.log(this.navParams.get('searchCriteriaDescription'));
  }

  itemTapped(event, set) {
    // push to browser able to display pdf downloaded from web url
    this.navCtrl.push(ResultsPage, {set: set});
    // todo
  }

}
