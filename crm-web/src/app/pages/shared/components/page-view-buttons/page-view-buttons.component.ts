import {
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    Input,
    OnInit,
    Output
} from '@angular/core';
import {PageView} from '../../data/shared.enum';
import {IPageViewOptions} from '../../data/shared.interface';

@Component({
    selector: 'ngx-page-view-buttons',
    templateUrl: './page-view-buttons.component.html',
    styles: [` `],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PageViewButtonsComponent implements OnInit {
    @Input()
    options: IPageViewOptions = {default: PageView.TABLE, buttons: []};

    @Output()
    viewChange: EventEmitter<PageView> = new EventEmitter<PageView>();
    view: PageView = PageView.TABLE;

    readonly PageViewType = PageView;

    constructor(
        private cd: ChangeDetectorRef,
    ) {
    }

    ngOnInit(): void {
        this.view = this.options.default;
    }

    onViewSelectionChange(value: any): void {
        this.viewChange.emit(value[0]);
        this.view = value[0];
        this.cd.markForCheck();
    }
}
