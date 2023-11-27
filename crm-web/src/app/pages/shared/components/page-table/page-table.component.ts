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
    tableHeader: IPageTableHeader = {title: '', buttons: []};
    @Input()
    tableCols: IPageTableCols[] = [];
    @Input()
    tableRows?: TemplateRef<any>[] = [];
    @Input()
    tableData?: Observable<any[]> = new Observable<any[]>();
    @Input()
    pageIndex: number = 0;
    @Output()
    pageIndexChange: EventEmitter<number> = new EventEmitter<number>();
    @Input()
    pageSize: number = 10;
    @Output()
    pageSizeChange: EventEmitter<number> = new EventEmitter<number>();
    @Input()
    pageTotalSize: number = 0;
    @Input()
    isLoading: boolean = false;
    @Input()
    showPagination: boolean = false;
    @Input()
    showSizeChanger: boolean = false;
    @Output()
    onAllRecordChecked: EventEmitter<boolean> = new EventEmitter<boolean>(false);
    @Output()
    onSingleRecordChecked: EventEmitter<any> = new EventEmitter<any>();


    constructor() {
    }

    ngOnInit(): void {
    }

    onCheckAllRecord(value: boolean) {
        console.log(value);
        this.onAllRecordChecked.emit(value);
    }

    onCheckSingleRecord(record: any) {
        console.log(record);
        this.onSingleRecordChecked.emit(record);
    }
}
