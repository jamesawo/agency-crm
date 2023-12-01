import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NbDateService} from '@nebular/theme';

@Component({
    selector: 'ngx-page-date-picker',
    templateUrl: './page-date-picker.component.html',
    styles: []
})
export class PageDatePickerComponent implements OnInit {

    @Input()
    fullWidth: boolean = true;

    @Input()
    value?: Date;

    @Output()
    valueChange: EventEmitter<Date> = new EventEmitter();

    @Input()
    max: Date;

    @Input()
    min: Date;

    @Input()
    placeHolder: string = 'Select a date';

    constructor(protected dateService: NbDateService<Date>) {
        this.max = this.dateService.today();
    }

    ngOnInit(): void {
    }

    onDateSelected(date: Date) {
        if (date) {
            this.valueChange.emit(date);
        }
    }
}
