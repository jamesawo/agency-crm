import {PageView} from '../../shared/data/shared.enum';
import {IPageTableCols, IPageTableHeader, IPageViewButton} from '../../shared/data/shared.interface';

export const pipelinePageViewButtons: IPageViewButton[] = [
    {
        type: PageView.TABLE, action: () => {
        },
    },
    {
        type: PageView.GRID, action: () => {
        },
    },
    {
        type: PageView.LIST, action: () => {
        },
    },
];

export const pipelineTableHeader: IPageTableHeader = {
    title: 'pipeline',
    buttons: [
        {
            icon: 'cloud-download-outline', tooltip: 'Download Records', action: () => {
            },
        },
        {
            icon: 'cloud-upload-outline', tooltip: 'Upload Records', action: () => {
            },
        },
        {
            icon: 'more-vertical-outline', tooltip: 'More Actions', action: () => {
            },
        },
    ],
};

export const pipelineTableColumns: IPageTableCols[] = [
    {title: 'First', type: 'string'},
    {title: 'Last', type: 'string'},
    {title: 'Handle of the pipeline', type: 'string'},
    {title: 'Date of Creation', type: 'string'},
    {title: 'State of the Pipeline', type: 'string'},
    {title: 'Status', type: 'string'},
    {title: 'Handle of the pipeline', type: 'string'},
    {title: 'Date of Creation', type: 'string'},
    {title: 'State of the Pipeline', type: 'string'},
    {title: 'Status', type: 'string'},
];
