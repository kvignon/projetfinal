import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import {Matiere} from '../classes/matiere';

@Component({
    selector: 'appmatieres',
    templateUrl: './matieres.component.html',
    styleUrls: ['./matieres.component.css']
})
export class MatieresComponent implements OnInit {

    matieres: Array<Matiere>;

    constructor(private http: Http) {
        this.matieres = [];
    }

    ngOnInit() {
        console.log('ngOnInit');
        this.http.get('http://localhost:8080/SchoolBoard-web/matiere')
            .subscribe(res => {
                for (const e of res.json()) {
                    this.matieres.push(new Matiere(e.id, e.nom, e.difficulte));
                }
            });
    }

}
