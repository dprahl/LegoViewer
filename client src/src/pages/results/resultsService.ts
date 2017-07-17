import{Http, Response, Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Injectable} from '@angular/core';

@Injectable()
export class ResultsService{
    constructor(private _http:Http){

    }

    getAllSets() : Observable<any> {
        return this._http.get("http://localhost:8080/sets/")
            .map(response => response.json());
    }

    getSetByDescription(description : string) : Observable<any> {
      return this._http.get("http://localhost:8080/sets/description/" + description)
            .map(response => response.json());
    }

    getSetByNumber(setNumber : string) : Observable<any> {
      return this._http.get("http://localhost:8080/sets/number/" + setNumber)
            .map(response => response.json());
    }

}
