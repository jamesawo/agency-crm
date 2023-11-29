import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'ngx-stages',
    templateUrl: './stages.component.html',
    styles: []
})
export class StagesComponent implements OnInit {

    @Input()
    name: string;

    constructor() {
    }

    ngOnInit(): void {
        console.log(this.name);
    }

}
