import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {PageView} from '../../shared/data/shared.enum';
import {IPageButton, IPageViewOptions} from '../../shared/data/shared.interface';
import {DrawerService} from '../../shared/service/drawer.service';
import {UIQuery} from '../../shared/state/shared.query';
import {PipelineSaveComponent} from '../_components/pipeline-save/pipeline-save.component';
import {pipelinePageViewButtons} from '../_data/pipeline-data';

@Component({
    selector: 'ngx-pipelines',
    templateUrl: './pipelines.component.html',
    styleUrls: ['./pipelines.component.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PipelinesComponent implements OnInit {
    pageViewOpts: IPageViewOptions = {buttons: pipelinePageViewButtons, default: PageView.TABLE};

    constructor(
        private query: UIQuery,
        private drawer: DrawerService
    ) {
    }

    openCreatePipelineDrawer = () => this.drawer.open(PipelineSaveComponent);
    onSearchButtonClick = () => console.info('searching for pipelines in database');

    pageButtons: IPageButton[] = [
        {
            text: 'Search',
            icon: 'search',
            size: 'medium',
            status: 'basic',
            shape: 'rectangle',
            action: this.onSearchButtonClick,
        },
        {
            text: 'Add',
            icon: 'plus',
            size: 'medium',
            status: 'primary',
            shape: 'rectangle',
            action: this.openCreatePipelineDrawer,
        },
    ];

    ngOnInit(): void {
        this.pageViewOpts.default = this.query.getPipelineView();
    }

}
