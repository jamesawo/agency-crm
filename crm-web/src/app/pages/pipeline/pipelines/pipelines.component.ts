import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {PageView} from '../../shared/data/shared.enum';
import {IPageButton, IPageViewOptions} from '../../shared/data/shared.interface';
import {pipelinePageButtons, pipelinePageViewButtons} from '../_data/pipeline-data';

@Component({
    selector: 'ngx-pipelines',
    templateUrl: './pipelines.component.html',
    styles: [],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PipelinesComponent implements OnInit {
    pageButtons: IPageButton[] = pipelinePageButtons;
    pageViewOpts: IPageViewOptions = {buttons: pipelinePageViewButtons, default: PageView.TABLE};

    constructor() {
    }

    ngOnInit(): void {
    }

}
