import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {PageView} from '../../shared/data/shared.enum';
import {IPageButton, IPageViewOptions} from '../../shared/data/shared.interface';
import {PageResponse} from '../../shared/data/shared.types';
import {DrawerService} from '../../shared/service/drawer.service';
import {UtilService} from '../../shared/service/util.service';
import {UIQuery} from '../../shared/state/shared.query';
import {PipelineFilterComponent} from '../_components/pipeline-filter/pipeline-filter.component';
import {PipelineSaveComponent} from '../_components/pipeline-save/pipeline-save.component';
import {Pipeline, PipelineSearchParam} from '../_data/pipeline.class';
import {pipelinePageViewButtons} from '../_data/pipeline.data';
import {PipelineService} from '../_state/pipeline.service';

@Component({
    selector: 'ngx-pipelines',
    templateUrl: './pipelines.component.html',
    styleUrls: ['./pipelines.component.scss'],
})
export class PipelinesComponent implements OnInit, OnDestroy {
    @ViewChild('pipelineFilterComponent')
    filterComponent?: PipelineFilterComponent;
    pageViewOpts: IPageViewOptions = {buttons: pipelinePageViewButtons, default: PageView.TABLE};
    searchParam: PipelineSearchParam = new PipelineSearchParam();
    isSearching: boolean = false;

    constructor(
        private query: UIQuery,
        private drawer: DrawerService,
        private service: PipelineService,
        private util: UtilService,
    ) {
    }

    ngOnInit(): void {
        this.pageViewOpts.default = this.query.getPipelineView();
    }

    openDrawer = () => this.drawer.open(PipelineSaveComponent);

    onSearch = async (): Promise<void> => {
        this.isSearching = true;
        const request = this.service.search(this.searchParam);
        const response = await this.util.handleRequest(request);
        this.isSearching = false;
        this.updateTable(response);
    };

    onClearFields = (): void => {
        this.searchParam.reset();
        this.filterComponent?.dateRange?.onClear();
    };

    pageButtons: IPageButton[] = [
        {
            text: 'Search',
            icon: 'search',
            size: 'medium',
            status: 'basic',
            shape: 'rectangle',
            action: this.onSearch,
            loading: this.isSearching
        },
        {
            text: 'Clear',
            icon: 'close',
            size: 'medium',
            status: 'basic',
            shape: 'rectangle',
            action: this.onClearFields,
        },
        {
            text: 'Add',
            icon: 'plus',
            size: 'medium',
            status: 'primary',
            shape: 'rectangle',
            action: this.openDrawer,
        },
    ];

    ngOnDestroy(): void {
        this.service.searchResult.next(null);
    }

    private updateTable(response: PageResponse<Pipeline[]>) {
        if (response.ok) {
            this.service.searchResult.next(response.body.data);
        }
    }
}
