import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AlertService, AuthenticationService } from '../_services/index';

@Component({
moduleId: module.id,
  templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;
constructor(
         private route: ActivatedRoute,
         private router: Router,
         private authentificationService: AuthenticationService,
         private alertservice: Alertservice) { }

  }


ngOnInit(){

  // renitialistation du login status
  this.authenticationService.logout();

  // url retour a partir des parametre par default '/'
  this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';

}

login(){

   this.loading  = true;
   this.authentication.login(this.model.username, this.model.password)
     .subscribe(
       data => {
        this.router.navigate([this.returnUrl]);
       },
       error => {
         this.alertService.eror(error);
         this.loading = false;
       });
}
