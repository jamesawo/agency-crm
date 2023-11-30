import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NbComponentSize} from '@nebular/theme/components/component-size';
import {IOption} from '../../data/shared.interface';

@Component({
    selector: 'ngx-page-dropdown',
    templateUrl: './page-dropdown.component.html',
    styles: []
})
export class PageDropdownComponent implements OnInit {

    @Input()
    title: string = '';

    @Input()
    source: IOption[];

    @Input()
    value?: any;

    @Output()
    valueChange = new EventEmitter<any>();

    @Input()
    size: NbComponentSize = 'medium';

    constructor() {
    }

    ngOnInit(): void {
    }

    onValueChange(value: any) {
        if (value) {
            this.valueChange.emit(value);
        }
    }
}
