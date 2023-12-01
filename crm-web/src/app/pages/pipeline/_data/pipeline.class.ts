import {NbCalendarRange} from '@nebular/theme';
import {IValidationStatus} from '../../shared/data/shared.interface';
import {StageAction, StageReviewType, StageStatus} from './pipeline.enum';
import {IPipeline, IStage} from './pipeline.interface';

export class Pipeline implements IPipeline {
    id: string = '';
    title: string = '';
    hierarchy: number = 0;
    stages: Stage[] = [];
    createdAt: string = '';

    constructor() {
    }

    addStage(stage: Stage): void {
        if (this.stages.length < 5) {
            this.stages.push(stage);
        }
    }

    removeStage(stage: Stage): void {
        this.stages = this.stages.filter(value => value !== stage);
    }

    reset(): void {
        this.stages = [];
        this.title = '';
        this.id = '';
        this.hierarchy = 0;
    }

}

export class Stage implements IStage {
    id: string = '';
    hierarchy: number = 0;
    action: StageAction = StageAction.FILE_UPLOAD;
    reviewType: StageReviewType = StageReviewType.MANUAL;
    stageValue: string = '';
    status: StageStatus = StageStatus.OPEN;
    title: string = '';
    validation: IValidationStatus = {status: true, message: ''};

    constructor(title = '') {
        this.title = title;
    }
}

export class PipelineSearchParam {
    title?: string;
    dateRange?: NbCalendarRange<Date>;
    createdBy?: string;
    isActive?: boolean;
    numOfStages?: number;

    constructor() {
    }

    reset() {
        this.title = null;
        this.dateRange = null;
        this.createdBy = null;
        this.isActive = null;
        this.numOfStages = null;
    }

}
