import {Component, Input, OnInit} from '@angular/core';
import {NbComponentShape} from '@nebular/theme';
import {NbComponentSize} from '@nebular/theme/components/component-size';
import {NbComponentOrCustomStatus} from '@nebular/theme/components/component-status';
import {ActionFn} from '../../data/shared.types';

@Component({
    selector: 'ngx-icon-button',
    templateUrl: './page-icon-button.component.html',
    styles: [],
})
export class PageIconButtonComponent implements OnInit {
    @Input()
    status: NbComponentOrCustomStatus = 'basic';

    @Input()
    shape: NbComponentShape = 'rectangle';

    @Input()
    size: NbComponentSize = 'small';

    @Input()
    icon: string = 'question-mark-outline';

    @Input()
    disabled: boolean = false;

    @Input()
    tooltip: string = '';

    @Input()
    class: string = '';

    @Input()
    args?: any;

    constructor() {
    }

    @Input()
    action: ActionFn = () => {
    };

    ngOnInit(): void {
    }

}
