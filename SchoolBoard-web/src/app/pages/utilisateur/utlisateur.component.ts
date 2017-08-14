import { Component, OnInit  } from '@angular/core';

@Component({
    selector: 'app-utilisateur',
    templateUrl: './utilisateur.component.html',
    styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {

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
