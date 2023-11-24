import {Component, Input, OnInit} from '@angular/core';
import {IPageButton} from '../../data/shared.interface';

@Component({
    selector: 'ngx-page-buttons',
    templateUrl: './page-buttons.component.html',
    styles: [],
})
export class PageButtonsComponent implements OnInit {
    @Input()
    buttons: IPageButton[] = [];

    constructor() {
    }

    ngOnInit(): void {
    }

}
