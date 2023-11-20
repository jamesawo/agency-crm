import {Component} from '@angular/core';

@Component({
    selector: 'ngx-footer',
    styleUrls: ['./footer.component.scss'],
    template: `
        <span class="created-by">
      {{appTitle}} <b><a href="{{appUrl}}" target="_blank">{{appDeveloper}}</a></b> {{appDate}}
    </span>
        <div class="socials" *ngIf="showSocials">
            <a href="#" target="_blank" class="ion ion-social-github"></a>
            <a href="#" target="_blank" class="ion ion-social-facebook"></a>
            <a href="#" target="_blank" class="ion ion-social-twitter"></a>
            <a href="#" target="_blank" class="ion ion-social-linkedin"></a>
        </div>
    `,
})
export class FooterComponent {
    appTitle = 'AgentCRM';
    appUrl = '#';
    appDeveloper = 'T-Media';
    appDate = new Date().getFullYear();
    showSocials = false;

}
