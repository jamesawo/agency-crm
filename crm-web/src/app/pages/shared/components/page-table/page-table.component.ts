import {Component, EventEmitter, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {Observable} from 'rxjs';
import {
    IPageTableCols,
    IPageTableHeader,
    IPageTableOptions,
    IPageTablePaginationOpts,
} from '../../data/shared.interface';

@Component({
    selector: 'ngx-page-table',
    templateUrl: './page-table.component.html',
    styles: [],
})
export class PageTableComponent implements OnInit, IPageTablePaginationOpts, IPageTableOptions {
    @Input()
    tableHeader: IPageTableHeader;
    @Input()
    tableCols: IPageTableCols[];
    @Input()
    tableRows?: TemplateRef<any>[];
    @Input()
    tableData?: Observable<any[]>;
    @Input()
    pageIndex: number = 0;
    @Output()
    pageIndexChange: EventEmitter<number>;
    @Input()
    pageSize: number = 10;
    @Output()
    pageSizeChange: EventEmitter<number>;
    @Input()
    pageTotalSize: number = 0;
    @Input()
    isLoading: boolean = false;
    @Input()
    showPagination: boolean = false;
    @Input()
    showSizeChanger: boolean = false;

    constructor() {
    }

    ngOnInit(): void {
    }

}
