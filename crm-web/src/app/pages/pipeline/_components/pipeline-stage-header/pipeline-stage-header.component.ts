import {AfterViewInit, Component, ElementRef, Input, OnInit, Renderer2, ViewChild} from '@angular/core';
import {NbToastrService} from '@nebular/theme';
import {pipe} from 'rxjs';
import {Pipeline, Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-header',
    templateUrl: './pipeline-stage-header.component.html',
    styles: [],
})
export class PipelineStageHeaderComponent implements OnInit, AfterViewInit {

    @ViewChild('titleInputRef') inputField?: ElementRef;

    @Input()
    pipeline?: Pipeline;
    protected readonly pipe = pipe;

    constructor(
        private toast: NbToastrService,
        private renderer: Renderer2
    ) {
    }

    ngAfterViewInit() {
        this.inputField.nativeElement.focus();
    }

    ngOnInit(): void {
    }

    onAddStage() {
        if (!this.pipeline || !this.pipeline.title) {
            return;
        }
        this.pipeline.addStage(new Stage());
    }
}
