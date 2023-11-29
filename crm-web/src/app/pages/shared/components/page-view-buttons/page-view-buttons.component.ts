import {
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    Input,
    OnInit,
    Output
} from '@angular/core';
import {NbComponentShape} from '@nebular/theme/components/component-shape';
import {NbComponentSize} from '@nebular/theme/components/component-size';
import {PageView} from '../../data/shared.enum';
import {IPageViewOptions} from '../../data/shared.interface';
import {UIQuery} from '../../state/shared.query';

@Component({
    selector: 'ngx-page-view-buttons',
    templateUrl: './page-view-buttons.component.html',
    styles: [` `],
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class PageViewButtonsComponent implements OnInit {
    @Input()
    size: NbComponentSize = 'medium';

    @Input()
    shape: NbComponentShape = 'rectangle';

    @Input()
    options: IPageViewOptions = {default: PageView.TABLE, buttons: []};

    @Output()
    viewChange: EventEmitter<PageView> = new EventEmitter<PageView>();
    view: PageView = PageView.TABLE;

    @Input()
    class = '';

    readonly PageViewType = PageView;

    constructor(
        private cd: ChangeDetectorRef,
        private query: UIQuery,
    ) {
    }

    ngOnInit(): void {
        this.view = this.options.default;
    }

    onViewSelectionChange(value: any): void {
        this.view = value[0];
        this.query.updatePipelineView(this.view);
        this.viewChange.emit(this.view);
        this.cd.markForCheck();
    }
}
