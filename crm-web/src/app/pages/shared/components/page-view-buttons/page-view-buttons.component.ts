import {AfterViewInit, ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit} from '@angular/core';

enum PageView {
    MAP = 'MAP',
    TABLE = 'TABLE',
    GRID = 'GRID',
    LIST = 'LIST',
}

@Component({
    selector: 'ngx-page-view-buttons',
    templateUrl: './page-view-buttons.component.html',
    styles: [],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PageViewButtonsComponent implements OnInit, AfterViewInit {
    viewType = PageView.MAP;

    readonly PageViewType = PageView;

    constructor(private cd: ChangeDetectorRef) {
    }

    updateSingleSelectGroupValue(value): void {
        this.viewType = value;
        this.cd.markForCheck();
        this.cd.detectChanges();
    }

    ngOnInit(): void {
    }

    ngAfterViewInit(): void {
        this.viewType = PageView.MAP;
        this.cd.detectChanges();
    }

}
