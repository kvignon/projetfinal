import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import { routerTransition } from '../../router.animations';



@Component({
  selector: 'app-etablissement',
   templateUrl: './etablissement.component.html',
    styleUrls: ['./etablissement.component.scss'],
        animations: [routerTransition()]
    
    })
export class EtablissementComponent implements OnInit {
    constructor() {
    }

    ngOnInit() {
    }
}