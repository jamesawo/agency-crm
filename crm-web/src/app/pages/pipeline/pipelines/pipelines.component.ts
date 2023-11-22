import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';

@Component({
    selector: 'ngx-pipelines',
    templateUrl: './pipelines.component.html',
    styles: [],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PipelinesComponent implements OnInit {

    constructor() {
    }

    ngOnInit(): void {
    }

}
