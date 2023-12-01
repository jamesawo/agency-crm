import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {NbCalendarRange, NbDateService} from '@nebular/theme';

@Component({
    selector: 'ngx-page-date-range',
    templateUrl: './page-date-range.component.html',
    styles: []
})
export class PageDateRangeComponent implements OnInit {
    localValue?: NbCalendarRange<Date>;

    @ViewChild('inputElement', {static: false})
    inputElement!: ElementRef<HTMLInputElement>;


    @Input()
    control: 'form-control' | 'ng-model' = 'ng-model';

    @Input()
    fullWidth: boolean = true;

    @Input()
    value?: NbCalendarRange<Date> = {start: null, end: null};

    @Output()
    valueChange: EventEmitter<NbCalendarRange<Date>> = new EventEmitter();

    @Input()
    placeholder: string = 'Select a date range';

    max?: Date;

    constructor(protected dateService: NbDateService<Date>) {
        this.max = this.dateService.today();
    }

    ngOnInit(): void {
    }

    onDateRangeChange(dateRange: NbCalendarRange<Date>) {
        if (dateRange) {
            this.valueChange.emit(dateRange);
        }
    }

    onClear() {
        this.localValue = null;
        this.value = null;
        this.valueChange.emit(null);
        this.inputElement.nativeElement.value = '';
    }
}
