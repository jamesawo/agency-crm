import {ChangeDetectionStrategy, Component, Input, OnInit, ViewChild} from '@angular/core';
import {PageDateRangeComponent} from '../../../shared/components/page-date-range/page-date-range.component';
import {PipelineSearchParam} from '../../_data/pipeline.class';

@Component({
    selector: 'ngx-pipeline-filter',
    templateUrl: './pipeline-filter.component.html',
    styles: [
        `
            nb-checkbox {
                margin-bottom: 1rem;
            }

            .form-inline [fullWidth] {
                flex: 1;
            }

            .form-inline > * {
                margin: 0 1.5rem 1.5rem 0;
            }

            nb-card.inline-form-card nb-card-body {
                padding-bottom: 0;
            }
        `,
    ],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class PipelineFilterComponent implements OnInit {
    @ViewChild('dateRangeComponent')
    public dateRange?: PageDateRangeComponent;


    @Input()
    searchParam: PipelineSearchParam = new PipelineSearchParam();


    constructor() {
    }

    ngOnInit(): void {
    }

}
