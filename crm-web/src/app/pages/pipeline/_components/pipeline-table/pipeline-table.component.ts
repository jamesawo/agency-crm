import {Component, OnInit} from '@angular/core';
import {of} from 'rxjs';
import {IPageButton, IPageTable} from '../../../shared/data/shared.interface';
import {pipelineTableColumns, pipelineTableHeader} from '../../_data/pipeline.data';
import {PipelineService} from '../../_state/pipeline.service';

@Component({
    selector: 'ngx-pipeline-table',
    templateUrl: './pipeline-table.component.html',
    styleUrls: ['./pipeline-table.component.scss'],
})
export class PipelineTableComponent implements OnInit {

    pipeLineTable: IPageTable = {
        tableHeader: pipelineTableHeader,
        tableColumns: pipelineTableColumns,
        tableRows: [],
        tableData: of([])
    };
    actionButtons: IPageButton[] = [
        {
            icon: 'edit', action: () => {
            }
        },
        {
            icon: 'close', action: () => {
            }
        },

    ];

    constructor(private service: PipelineService) {
    }

    ngOnInit(): void {
        this.service.searchResult$.subscribe({
            next: (value) => {
                if (value) {
                    this.pipeLineTable = {...this.pipeLineTable, tableData: of(value.content)};
                }
            }
        });
    }
}
