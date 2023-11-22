import {Component, Input, OnInit, TemplateRef} from '@angular/core';
import {NbPosition, NbTrigger} from '@nebular/theme';

@Component({
    selector: 'ngx-page-header',
    template: `
        <div class="">
            <div class="d-flex align-items-center gap-3">
                <h4>{{pageTitle}}</h4>
                <ng-container *ngIf="hint">
                    <nb-icon
                            [nbPopoverTrigger]="NbTrigger.HOVER" [nbPopoverPlacement]="NbPosition.RIGHT"
                            [nbPopover]="hint"
                            icon="alert-circle-outline"
                    ></nb-icon>
                </ng-container>
            </div>
            <p>{{pageDescription}}</p>
        </div>
    `,
    styles: [`
        nb-icon {
            font-size: 0.9rem;
        }
    `],
})
export class PageHeaderComponent implements OnInit {
    @Input()
    pageTitle = '';

    @Input()
    pageDescription = '';

    @Input()
    hint: TemplateRef<any>;
    protected readonly NbTrigger = NbTrigger;
    protected readonly NbPosition = NbPosition;

    constructor() {
    }

    ngOnInit(): void {
    }
}
