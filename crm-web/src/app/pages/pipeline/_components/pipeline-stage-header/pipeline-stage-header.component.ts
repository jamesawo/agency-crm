import {Component, Input, OnInit} from '@angular/core';
import {NbToastrService} from '@nebular/theme';
import {pipe} from 'rxjs';
import {Pipeline, Stage} from '../../state/pipeline.class';

@Component({
    selector: 'ngx-pipeline-stage-header',
    templateUrl: './pipeline-stage-header.component.html',
    styles: [],
})
export class PipelineStageHeaderComponent implements OnInit {

    @Input()
    pipeline?: Pipeline;
    protected readonly pipe = pipe;

    constructor(private toast: NbToastrService) {
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
