import {HttpResponse} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {DrawerService} from '../../../shared/service/drawer.service';
import {UtilService} from '../../../shared/service/util.service';
import {Pipeline} from '../../_data/pipeline.class';
import {PipelineService} from '../../_state/pipeline.service';

@Component({
    selector: 'ngx-pipeline-save',
    templateUrl: './pipeline-save.component.html',
    styleUrls: ['./pipeline-save.component.scss']
})
export class PipelineSaveComponent implements OnInit {
    loading = false;
    pipeline: Pipeline = new Pipeline();

    constructor(
        private pipelineService: PipelineService,
        private util: UtilService,
        private drawer: DrawerService
    ) {
    }

    ngOnInit(): void {
    }

    onResetForm(): void {
        this.pipeline.reset();
    }

    async onSavePipeline(): Promise<void> {
        this.loading = true;
        const result = await this.util.handleRequest(this.pipelineService.create(this.pipeline));
        this.loading = false;
        this.closeAfterSave(result);
    }

    private closeAfterSave(result: HttpResponse<any>) {
        if (result.ok) {
            this.pipeline.reset();
            this.drawer.close();
        }
    }
}
