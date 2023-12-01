import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'ngx-page-search-fields',
    templateUrl: './page-search-fields.component.html',
    styles: [],
})
export class PageSearchFieldsComponent implements OnInit {
    @Input()
    open = false;

    constructor() {
    }

    ngOnInit(): void {
    }

}
