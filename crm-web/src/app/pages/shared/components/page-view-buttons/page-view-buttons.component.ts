import {ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';
import {PageView} from '../../data/shared.enum';
import {IPageViewButton, IPageViewOptions} from '../../data/shared.interface';

@Component({
    selector: 'ngx-page-view-buttons',
    templateUrl: './page-view-buttons.component.html',
    styles: [` `],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PageViewButtonsComponent implements OnInit {
    @Input()
    options: IPageViewOptions;

    @Input()
    views: IPageViewButton[];

    viewType = PageView.MAP;

    readonly PageViewType = PageView;

    constructor(private cd: ChangeDetectorRef) {
    }

    updateSingleSelectGroupValue(value): void {
        this.viewType = value;
        this.cd.markForCheck();
    }

    ngOnInit(): void {
    }
}
