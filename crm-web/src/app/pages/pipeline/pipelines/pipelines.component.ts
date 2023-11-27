import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {PageView} from '../../shared/data/shared.enum';
import {IPageButton, IPageViewOptions} from '../../shared/data/shared.interface';
import {UIQuery} from '../../shared/state/shared.query';
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

    constructor(private uiQuery: UIQuery) {
    }

    ngOnInit(): void {
        this.pageViewOpts.default = this.uiQuery.getPipelineView();
    }

    handleViewChange(view: PageView) {
        this.uiQuery.updatePipelineView(view);
    }
}
