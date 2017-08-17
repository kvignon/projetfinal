import {Component} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';


@Component({
    selector: 'apputilisateur',
    templateUrl: './utilisateur.component.html',
    styleUrls: ['./utilisateur.component.scss']
})
export class Utilisateur {

    listeUtilisateur: Array<any>;

    constructor() {
        this.listeUtilisateur = [{ prenom: 'Jena' , nom: 'lovren'},
            { prenom: 'eric', nom: 'sultan' }

        ];
    }

    ngOnInit() {
    }

    clickSurUnePersonne(unUtilisateur) {
        console.log('event recu');
        console.log(`prenom:${unUtilisateur.prenom}, nom:${unUtilisateur.nom}`);
    }

}
