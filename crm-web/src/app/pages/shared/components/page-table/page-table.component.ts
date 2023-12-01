import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, TemplateRef} from '@angular/core';
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
    // changeDetection: ChangeDetectionStrategy.OnPush
})
export class PageTableComponent implements OnInit, OnChanges, IPageTablePaginationOpts, IPageTableOptions {
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
        console.log('ngOnInit in PageTableComponent');
    }

    ngOnChanges(changes: SimpleChanges): void {
        console.log('ngOnChanges called in PageTableComponent', changes);
    }

    onCheckAllRecord(value: boolean) {
        this.onAllRecordChecked.emit(value);
    }

    onCheckSingleRecord(record: any) {
        this.onSingleRecordChecked.emit(record);
    }
}
