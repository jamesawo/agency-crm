import {EventEmitter, TemplateRef} from '@angular/core';
import {NbComponentShape} from '@nebular/theme/components/component-shape';
import {NbComponentSize} from '@nebular/theme/components/component-size';
import {NbComponentOrCustomStatus} from '@nebular/theme/components/component-status';
import {PageView} from './shared.enum';
import {ActionFn} from './shared.types';

export interface IPageTableHeaderButton {
    icon: string;
    tooltip: string;
    action: ActionFn;
}

export interface IPageTableHeader {
    title: string;
    buttons: IPageTableHeaderButton[];
}

export interface IPageTableOptions {
    showPagination: boolean;
    showSizeChanger: boolean;
    isLoading: boolean;
}

export interface IPageTablePaginationOpts {
    pageIndex: number;
    pageIndexChange: EventEmitter<number>;
    pageSize: number;
    pageSizeChange: EventEmitter<number>;
    pageTotalSize: number;
}

export interface IPageTableCols {
    title: string;
    type?: 'string' | 'number' | 'boolean';
    width?: number;
}

export interface IPageTable {
    tableHeader: IPageTableHeader;
    tableColumns: IPageTableCols[];
    tableRows?: TemplateRef<any>[];
}

export interface IPageViewButton {
    type: PageView;
    action: ActionFn;
}

export interface IPageViewOptions {
    buttons: IPageViewButton[];
    default: PageView;
}

export interface IPageButton {
    text: string;
    icon: string;
    size: NbComponentSize;
    status: NbComponentOrCustomStatus;
    shape: NbComponentShape;
    action: ActionFn;
}
