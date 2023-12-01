import {EventEmitter, TemplateRef} from '@angular/core';
import {NbComponentShape} from '@nebular/theme/components/component-shape';
import {NbComponentSize} from '@nebular/theme/components/component-size';
import {NbComponentOrCustomStatus} from '@nebular/theme/components/component-status';
import {Observable} from 'rxjs';
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
    tableData?: Observable<any[]>;
    tablePage?: IPagination;
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
    text?: string;
    icon?: string;
    size?: NbComponentSize;
    status?: NbComponentOrCustomStatus;
    shape?: NbComponentShape;
    action?: ActionFn;
    args?: any;
    loading?: boolean;
}

export interface IOption {
    label: string;
    value: any;
}

export interface IValidationStatus {
    status: boolean;
    message: string;
}

export interface IPaginate<T> {
    pageNumber: number;
    pageSize: number;
    totalPages: number;
    totalElements: number;
    sort: { direction: 'ASC' | 'DESC', property: string };
    content?: T;
}

export interface IPagination extends IPaginate<any> {
}
