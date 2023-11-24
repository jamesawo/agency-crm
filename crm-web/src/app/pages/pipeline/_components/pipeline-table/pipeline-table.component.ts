import {Component, OnInit} from '@angular/core';
import {IPageTable} from '../../../shared/data/shared.interface';
import {pipelineTableColumns, pipelineTableHeader} from '../../_data/pipeline-data';

@Component({
    selector: 'ngx-pipeline-table',
    templateUrl: './pipeline-table.component.html',
    styleUrls: ['./pipeline-table.component.scss'],
})
export class PipelineTableComponent implements OnInit {

    pipeLineTable: IPageTable = {
        tableHeader: pipelineTableHeader,
        tableColumns: pipelineTableColumns,
    };

    constructor() {
    }

    ngOnInit(): void {
    }

}
